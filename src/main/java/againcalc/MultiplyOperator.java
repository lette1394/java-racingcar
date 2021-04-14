package againcalc;

public class MultiplyOperator implements Operator {
  @Override
  public long compute(long left, long right) {
    return left * right;
  }
}
