public class HaltInstruction implements Instruction {

  HaltInstruction(){
  }

  @Override
  public int toInt() {
    return 0;
  }

  @Override
  public String toString(){
    return "HALT";
  }

  @Override
  public Num toNum(){
    if(main.showWorkings) System.out.println("HALT instruction = 0");
    return new Num(toInt());
  }

  @Override
  public DoublePair toDoublePair(){
    throw new IllegalArgumentException("Halt instruction has no double pair encoding");
  }

  @Override
  public SinglePair toSinglePair() {
    return toNum().toSinglePair();
  }


  public Instruction toInstruction() {
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    return o != null && getClass() == o.getClass();
  }
}
