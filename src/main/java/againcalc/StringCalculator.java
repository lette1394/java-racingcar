package againcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
  private final Pattern pattern = Pattern.compile("(.*) ([+*/\\-]+) (\\d+)");

  public long calculate(String expression) {
    if (expression == null) {
      throw new IllegalArgumentException();
    }

    final Matcher matcher = pattern.matcher(expression);
    if (!matcher.matches()) {
      return Long.parseLong(expression);
    }

    final String restExpression = matcher.group(1);
    final long leftOperand = calculate(restExpression);
    final String operator = matcher.group(2);
    final long rightOperand = Long.parseLong(matcher.group(3));

    return operate(leftOperand, operator, rightOperand);
  }

  private long operate(long leftOperand, String operator, long rightOperand) {
    if (operator.equals("+")) {
      return leftOperand + rightOperand;
    }
    if (operator.equals("-")) {
      return leftOperand - rightOperand;
    }
    if (operator.equals("/")) {
      return leftOperand / rightOperand;
    }
    if (operator.equals("*")) {
      return leftOperand * rightOperand;
    }

    throw new IllegalArgumentException("unsupported operator: " + operator);
  }
}
