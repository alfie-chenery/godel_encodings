public interface Encoding {
  int toInt();
  String toString();
  Num toNum();
  DoublePair toDoublePair();
  SinglePair toSinglePair();
  Instruction toInstruction();
}
