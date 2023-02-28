import java.util.Objects;

public class Num implements Encoding {
  private final int n;

  Num(int n){
    if(n < 0){
      throw new IllegalArgumentException("Num must be a natural number");
    }
    this.n = n;
  }

  @Override
  public int toInt() {
    return n;
  }

  @Override
  public String toString() {
    return Integer.toString(n);
  }

  @Override
  public Num toNum() {
    return this;
  }

  public boolean isEven(){
    return n % 2 == 0;
  }

  //TODO refactor out duplication in toDoublePair and toSinglePair

  @Override
  public DoublePair toDoublePair(){
    if(n == 0){
      throw new IllegalArgumentException("0 has no double pair encoding");
    }
    int k = n;
    int y;
    int x = 0;
    while (true){
      if(k % 2 == 1){ //k is odd
        y = (k-1)/2;
        break;
      } else {
        x++;
        k /= 2;
      }
    }
    DoublePair result = new DoublePair(new Num(x), new Num(y));

    if(main.showWorkings){
      System.out.println("--- " + n + " toDoublePair: = 2^x(2y+1) ---");
      System.out.println("2 can divide " + n + ", " + x + " times, so x = " + x);
      System.out.println(n + "/2^" + x + " = 2y+1 = " + n/ (int) Math.pow(2,x) + ", so y = " + y);
      System.out.println("=== " + result.toString());
      System.out.println("-------");
    }

    return result;
  }

  @Override
  public SinglePair toSinglePair(){
    int k = n+1;
    int y;
    int x = 0;
    while (true){
      if(k % 2 == 1){ //k is odd
        y = (k-1)/2;
        break;
      } else {
        x++;
        k /= 2;
      }
    }
    SinglePair result = new SinglePair(new Num(x), new Num(y));

    if(main.showWorkings){
      System.out.println("--- " + toInt() + " toSinglePair: = 2^x(2y+1)-1 ---");
      System.out.println("2 can divide " + (toInt()+1) + ", " + x + " times, so x = " + x);
      System.out.println((toInt()+1) + "/2^" + x + " = 2y+1 = " + (toInt()+1)/ (int) Math.pow(2,x) + ", so y = " + y);
      System.out.println("=== " + result.toString());
      System.out.println("-------");
    }

    return result;
  }

  @Override
  public Instruction toInstruction() {
    if(n == 0) {
      if(main.showWorkings) System.out.println("0 encodes HALT instruction");
      return new HaltInstruction();
    }
    return toDoublePair().toInstruction();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Num num = (Num) o;
    return n == num.n;
  }

  @Override
  public int hashCode() {
    return Objects.hash(n);
  }
}
