package againcalc;

public class DivideOperator implements Operator {
  @Override
  public long compute(long left, long right) {
    return left / right;
  }
}
