public class main {

  public static final boolean showWorkings = false;

  public static void main(String[] args) {

//    new Num(2).toDoublePair();

//    Encoding enc = new Num(1);
//    System.out.println(enc.toString() + " =");
//    System.out.println(enc.toNum());
//    System.out.println(enc.toDoublePair());
//    System.out.println(enc.toSinglePair());
//    System.out.println(enc.toInstruction());

    for (int i = 0; i < 10; i++) {
      Num n = new Num(i);
      StringBuilder sb = new StringBuilder();
      sb.append(n.toString()).append(" = ");
      try{
        sb.append(n.toDoublePair().toString());
      } catch (IllegalArgumentException e) {
        sb.append(" N/A ");
      }
      sb.append(" = ")
          .append(n.toSinglePair().toString())
          .append(" = ")
          .append(n.toInstruction().toString());
      System.out.println(sb.toString());
    }

//    List list = new List();
//    list.push(new PlusInstruction(0,0));
//    list.push(new MinusInstruction(0,0,0));
//
//
//    System.out.println(list);
//    System.out.println(list.toDoublePair());
//    System.out.println(list.toNum());
//    System.out.println(list);
//    System.out.println("");
//    list.map(Encoding::toNum);
//    System.out.println(list);
//    System.out.println(list.toDoublePair());
//    System.out.println(list.toNum());
//    System.out.println("");
//    list.map(Encoding::toSinglePair);
//    System.out.println(list);
//    System.out.println(list.toDoublePair());
//    System.out.println(list.toNum());
  }
}
