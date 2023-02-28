import java.util.Objects;

public class DoublePair implements Encoding {
  private final Encoding x;
  private final Encoding y;

  DoublePair(Encoding x, Encoding y){
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
    //Math.pow returns double, but because all inputs are ints, we can be
    // sure the result will be an int, and so the casting is safe
    int lhs = x.toInt();
    int rhs = y.toInt();
    int result = (int) (Math.pow(2, lhs) * (2*rhs + 1));


    if(main.showWorkings){
      System.out.println("--- " + this + " toNum: = 2^x(2y+1) ---");
      System.out.println("= 2^" + lhs + " * (2*" + rhs + "+1)");
      System.out.println("= " + Math.pow(2, lhs) + " * " + (2*rhs + 1));
      System.out.println("=== " + result);
    }

    return result;
  }

  @Override
  public String toString(){
    return "⟪"+ x.toString() +","+ y.toString() +"⟫";
  }

  @Override
  public Num toNum(){
    return new Num(toInt());
  }

  @Override
  public DoublePair toDoublePair() {
    return this;
  }

  @Override
  public SinglePair toSinglePair(){
    return toNum().toSinglePair();
  }

  @Override
  public Instruction toInstruction() {
    Instruction result;
    if (main.showWorkings) System.out.println("--- " + this + " toInstruction ---");
//    if(toInt() == 0) return new HaltInstruction(); - not possible, a double pair encoding cannot be equal to 0
    if (x.toNum().isEven()) {

      if (main.showWorkings) {
        System.out.println(x.toNum() + " is even so Plus instruction ⟪2i,j⟫ = Ri+ -> Lj");
        System.out.println("so i = " + x.toInt() / 2);
        System.out.println("and j = " + y.toInt());
        //System.out.println("= R" + x.toInt() / 2 + "+ -> L" + y.toInt());
      }
      result = new PlusInstruction(x.toInt() / 2, y.toInt());

    } else {

      if (main.showWorkings) {
        System.out.println(x.toNum() + " is odd so Minus instruction ⟪2i+1,⟨j,k⟩⟫ = Ri- -> Lj,Lk");
        System.out.println("so i = " + (x.toInt() - 1) / 2);
        System.out.println("and " + y + " = ⟨j,k⟩");
      }

      SinglePair rhs = y.toSinglePair();
      result = new MinusInstruction((x.toInt() - 1) / 2, rhs.fst().toInt(), rhs.snd().toInt());

      if(main.showWorkings) {
        System.out.println("so y = " + rhs);
        System.out.println("so j = " + rhs.fst().toInt());
        System.out.println("and k = " + rhs.snd().toInt());
        //System.out.println("= R" + (x.toInt()-1) / 2 + "- -> L" + rhs.fst().toInt() + ",L" + rhs.snd().toInt());
      }
    }

    if(main.showWorkings) {
      System.out.println("=== " + result.toString());
      System.out.println("-------");
    }
    return result;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DoublePair that = (DoublePair) o;
    return Objects.equals(x, that.x) &&
        Objects.equals(y, that.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
