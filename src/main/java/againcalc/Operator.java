package againcalc;

@FunctionalInterface
public interface Operator {
  long compute(long left, long right);
}
