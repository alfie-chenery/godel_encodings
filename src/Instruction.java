public interface Instruction extends Encoding {
  /*
   * Instruction of the form:
   * HALT
   * PLUS  => R(lhs)+ -> L(rhs1)
   * MINUS => R(lhs)- -> L(rhs1),L(rhs2)
   */
}
