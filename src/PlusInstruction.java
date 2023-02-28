import java.util.Objects;

public class PlusInstruction implements Instruction {
  private final int lhs;
  private final int rhs;

  PlusInstruction(int lhs, int rhs){
    if(lhs < 0 || rhs < 0){
      throw new IllegalArgumentException("Registers and labels must be a natural number");
    }
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override
  public int toInt() {
    return toDoublePair().toInt();
  }

  @Override
  public String toString(){
    return "R" + lhs + "+ -> L" + rhs;
  }

  @Override
  public Num toNum(){
    return toDoublePair().toNum();
  }

  @Override
  public DoublePair toDoublePair(){
    DoublePair result = new DoublePair(new Num(lhs*2), new Num(rhs));

    if(main.showWorkings){
      System.out.println("--- " + this + " toDoublePair: = ⟪2i,j⟫ ---");
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
    PlusInstruction that = (PlusInstruction) o;
    return lhs == that.lhs &&
        rhs == that.rhs;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lhs, rhs);
  }
}
