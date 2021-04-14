package againcalc;

public class AddOperator implements Operator {
  @Override
  public long compute(long left, long right) {
    return left + right;
  }
}
