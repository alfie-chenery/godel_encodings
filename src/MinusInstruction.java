import java.util.Objects;

public class MinusInstruction implements Instruction {
  private final int lhs;
  private final int rhs1;
  private final int rhs2;

  MinusInstruction(int lhs, int rhs1, int rhs2){
    if(lhs < 0 || rhs1 < 0 || rhs2 < 0){
      throw new IllegalArgumentException("Registers and labels must be a natural number");
    }
    this.lhs = lhs;
    this.rhs1 = rhs1;
    this.rhs2 = rhs2;
  }

  @Override
  public int toInt() {
    return toDoublePair().toInt();
  }

  @Override
  public String toString(){
    return "R" + lhs + "- -> L" + rhs1 + ",L" + rhs2;
  }

  @Override
  public Num toNum(){
    return toDoublePair().toNum();
  }

  @Override
  public DoublePair toDoublePair() {
    DoublePair result = new DoublePair(new Num(lhs * 2 + 1), new SinglePair(new Num(rhs1), new Num(rhs2)));

    if(main.showWorkings){
      System.out.println("--- " + this + " toDoublePair: = ⟪2i+1,⟨j,k⟩⟫ ---");
      System.out.println("=== " + result);
      System.out.println("-------");
    }
    return result;
  }

  @Override
  public SinglePair toSinglePair() {
    return toDoublePair().toSinglePair();
  }


  public Instruction toInstruction() {
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MinusInstruction that = (MinusInstruction) o;
    return lhs == that.lhs &&
        rhs1 == that.rhs1 &&
        rhs2 == that.rhs2;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lhs, rhs1, rhs2);
  }
}
