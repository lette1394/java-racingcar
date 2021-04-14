package againcalc;

public class SubtractOperator implements Operator {
  @Override
  public long compute(long left, long right) {
    return left - right;
  }
}
