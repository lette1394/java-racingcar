package againcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringCalculator {
  private final static Pattern pattern = Pattern.compile("(.*) ([+*/\\-]+) (\\d+)");
  private final Operators operators;

  public long calculate(String expression) {
    if (expression == null) {
      throw new IllegalArgumentException();
    }

    final Matcher matcher = pattern.matcher(expression);
    if (!matcher.matches()) {
      return Long.parseLong(expression);
    }

    final String rest = matcher.group(1);
    final long left = calculate(rest);
    final String operator = matcher.group(2);
    final long right = Long.parseLong(matcher.group(3));

    return operators.parse(operator)
      .compute(left, right)
      .orElseThrow(() -> new IllegalArgumentException("illegal operator"));
  }
}
