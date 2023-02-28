import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TestSuite {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void invalidNumConstructor(){
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("must be a natural number");
    new Num(-1);
  }

  @Test
  public void validNumToDoublePair(){
    assertEquals(new Num(1).toDoublePair(), new DoublePair(new Num(0), new Num(0)));
    assertEquals(new Num(3).toDoublePair(), new DoublePair(new Num(0), new Num(1)));
    assertEquals(new Num(42).toDoublePair(), new DoublePair(new Num(1), new Num(10)));
    assertEquals(new Num(123456).toDoublePair(), new DoublePair(new Num(6), new Num(964)));
  }

  @Test
  public void invalidNumToDoublePair(){
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("no double pair encoding");
    new Num(0).toDoublePair();
  }

  @Test
  public void validDoublePairToNum(){
    assertEquals(new DoublePair(new Num(0), new Num(0)).toNum(), new Num(1));
    assertEquals(new DoublePair(new Num(1), new Num(2)).toNum(), new Num(10));
    assertEquals(new DoublePair(new Num(6), new Num(9)).toNum(), new Num(1216));
  }

  @Test
  public void validNumToSinglePair(){
    assertEquals(new Num(0).toSinglePair(), new SinglePair(new Num(0), new Num(0)));
    assertEquals(new Num(1).toSinglePair(), new SinglePair(new Num(1), new Num(0)));
    assertEquals(new Num(123).toSinglePair(), new SinglePair(new Num(2), new Num(15)));
    assertEquals(new Num(31415926).toSinglePair(), new SinglePair(new Num(0), new Num(15707963)));
  }

  @Test
  public void validSinglePairToNum(){
    assertEquals(new SinglePair(new Num(0), new Num(0)).toNum(), new Num(0));
    assertEquals(new SinglePair(new Num(4), new Num(2)).toNum(), new Num(79));
    assertEquals(new SinglePair(new Num(12), new Num(987)).toNum(), new Num(8089599));
  }

  @Test
  public void validDoublePairToSinglePair(){
    assertEquals(new DoublePair(new Num(0), new Num(0)).toSinglePair(),
        new SinglePair(new Num(1), new Num(0)));
    assertEquals(new DoublePair(new Num(1), new Num(2)).toSinglePair(),
        new SinglePair(new Num(0), new Num(5)));
  }

  @Test
  public void validSinglePairToDoublePair(){
    assertEquals(new SinglePair(new Num(1), new Num(1)).toDoublePair(),
        new DoublePair(new Num(0), new Num(2)));
    assertEquals(new SinglePair(new Num(0), new Num(3)).toDoublePair(),
        new DoublePair(new Num(1), new Num(1)));
  }

  @Test
  public void invalidSinglePairToDoublePair(){
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("no double pair encoding");
    new SinglePair(new Num(0), new Num(0)).toDoublePair();
  }

  @Test
  public void validDoublePairToSinglePairToNum(){
    assertEquals(
        new DoublePair(new Num(0), new Num(0)).toNum(),
        new DoublePair(new Num(0), new Num(0)).toSinglePair().toNum());
  }

  @Test
  public void validNumToInstruction(){
    assertEquals(new HaltInstruction(), new Num(0).toInstruction());
    assertEquals(new PlusInstruction(0,0), new Num(1).toInstruction());
    assertEquals(new MinusInstruction(0,0,0), new Num(2).toInstruction());
    assertEquals(new PlusInstruction(2,3), new Num(112).toInstruction());
    assertEquals(new MinusInstruction(4,5,6), new Num(425472).toInstruction());
  }

  @Test
  public void validInstructionToNum(){
    assertEquals(new Num(0), new HaltInstruction().toNum());
    assertEquals(new Num(1), new PlusInstruction(0,0).toNum());
    assertEquals(new Num(2), new MinusInstruction(0,0,0).toNum());
    assertEquals(new Num(30), new MinusInstruction(0,3,0).toNum());
    assertEquals(new Num(44), new PlusInstruction(1,5).toNum());
  }

  @Test
  public void validDoublePairToInstruction(){
    assertEquals(new DoublePair(new Num(8), new Num(20)).toInstruction(),
        new PlusInstruction(4,20));
    assertEquals(new DoublePair(new Num(7), new SinglePair(new Num(8), new Num(9))).toInstruction(),
        new MinusInstruction(3,8,9));
    assertEquals(new DoublePair(new Num(4), new DoublePair(new Num(4), new Num(4))).toInstruction(),
        new PlusInstruction(2,144));
    assertEquals(new DoublePair(new Num(3), new Num(47)).toInstruction(),
        new MinusInstruction(1,4,1));
  }

  @Test
  public void validInstructionToDoublePair(){
  }

  @Test
  public void invalidInstructionToDoublePair(){
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("no double pair encoding");
    new HaltInstruction().toDoublePair();
  }

  @Test
  public void validSinglePairInstruction(){
  }

  @Test
  public void validInstructionToSinglePair(){
  }





  @Test
  public void noConversionTest(){
    assertEquals(
        new Num(1862873),
        new Num(1862873).toNum());
    assertEquals(
        new DoublePair(new Num(6), new Num(9)),
        new DoublePair(new Num(6), new Num(9)).toDoublePair());
    assertEquals(
        new SinglePair(new Num(4), new Num(2)),
        new SinglePair(new Num(4), new Num(2)).toSinglePair());
    assertEquals(
        new PlusInstruction(0,1),
        new PlusInstruction(0,1).toInstruction());
  }

  @Test
  public void BackAndForthTest(){
    assertEquals(
        new Num(1862873),
        new Num(1862873).toDoublePair().toNum());
    assertEquals(
        new DoublePair(new Num(6), new Num(9)),
        new DoublePair(new Num(6), new Num(9)).toNum().toDoublePair());
    assertEquals(
        new SinglePair(new Num(4), new Num(2)),
        new SinglePair(new Num(4), new Num(2)).toDoublePair().toSinglePair());
    assertEquals(
        new PlusInstruction(0,1),
        new PlusInstruction(0,1).toSinglePair().toNum().toInstruction());
  }

  @Test
  public void multiStepConversionTest(){
    assertEquals(
        new DoublePair(new Num(0), new Num(0)).toNum(),
        new DoublePair(new Num(0), new Num(0))
            .toSinglePair()
            .toNum()
            .toInstruction()
            .toSinglePair()
            .toSinglePair()
            .toDoublePair()
            .toSinglePair()
            .toNum()
    );
  }

  //@Test
  //list tests

}
