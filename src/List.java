import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;

public class List implements Encoding{
  private final ArrayList<Encoding> list;

  List(ArrayList<Encoding> list){
    this.list = list;
  }

  List(){
    this(new ArrayList<Encoding>());
  }

  public void push(Encoding e){
    list.add(0, e);
  }

  public Encoding pop(){
    if(list.size() == 0){
      throw new IndexOutOfBoundsException("Cannot pop from an empty list");
    }
    return list.remove(0);
  }

  //TODO CHECK THIS - order of elements might be messed up

  /**
   * Takes a function and applies this independently to every element of the list.
   * The list is mutated, and this function returns no value
   * @param f a function from Encoding to Encoding
   */
  public void map(Function<Encoding,Encoding> f){
    for(int i=0; i<list.size(); i++){
      Encoding e = list.remove(i);
      list.add(i, f.apply(e));
    }
  }

  @Override
  public String toString() {
    return list.toString();
  }

  @Override
  public int toInt() {
    if(list.size() == 0) return 0;
    return toDoublePair().toInt();
  }

  @Override
  public Num toNum() {
    return new Num(toInt());
  }

  @Override
  public DoublePair toDoublePair() {

    if(list.size() == 0){
      throw new IllegalArgumentException("Empty list has no double pair encoding");
    }
    //classCast exception cannot happen since we already deal with empty list
    // which is the only case where helper returns a num instead of double pair
    return (DoublePair) toDoublePairHelper((ArrayList<Encoding>) list.clone());

  }

  private Encoding toDoublePairHelper(ArrayList<Encoding> l){
    if(l.size() == 0){
      return new Num(0);
    }
    return new DoublePair(l.remove(0), toDoublePairHelper(l));
  }

  @Override
  public SinglePair toSinglePair() {
    return toDoublePair().toSinglePair();
  }

  @Override
  public Instruction toInstruction() {
    //for testing
    if(toDoublePair().toInstruction() != toNum().toInstruction()){
      throw new UnsupportedOperationException("List to instruction has different results");
    }
    return toDoublePair().toInstruction();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    List list1 = (List) o;
    return Objects.equals(list, list1.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }
}
