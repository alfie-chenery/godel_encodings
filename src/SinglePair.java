import java.util.Objects;

public class SinglePair implements Encoding {
  private final Encoding x;
  private final Encoding y;

  SinglePair(Encoding x, Encoding y){
    this.x = x;
    this.y = y;
  }

  public Encoding fst(){
    return x;
  }

  public Encoding snd(){
    return y;
  }

  @Override
  public int toInt() {
    int result = (int) (Math.pow(2, x.toInt()) * (2*y.toInt() + 1) - 1);

    if(main.showWorkings){
      System.out.println("--- " + this + " toNum: = 2^x(2y+1)-1 ---");
      System.out.println("= 2^" + x.toInt() + " * (2*" + y.toInt() + "+1)-1");
      System.out.println("= " + Math.pow(2, x.toInt()) + " * " + (2*y.toInt() + 1) + " -1");
      System.out.println("= " + (int) (Math.pow(2, x.toInt()) * (2*y.toInt() + 1)) + " -1");
      System.out.println("=== " + result);
    }

    return result;
  }

  @Override
  public String toString(){
    return "⟨"+ x.toString() +","+ y.toString() +"⟩";
  }

  @Override
  public Num toNum(){
    return new Num(toInt());
  }

  @Override
  public DoublePair toDoublePair(){
    return toNum().toDoublePair();
  }

  @Override
  public SinglePair toSinglePair() {
    return this;
  }

  @Override
  public Instruction toInstruction() {
    return toNum().toInstruction();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SinglePair that = (SinglePair) o;
    return Objects.equals(x, that.x) &&
        Objects.equals(y, that.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
