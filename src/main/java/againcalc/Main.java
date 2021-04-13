package againcalc;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final Operators operators = new Operators(new HashMap<>() {{
      put("+", new AddOperator());
      put("-", new SubtractOperator());
      put("*", new MultiplyOperator());
      put("/", new DivideOperator());
    }});
    final StepFactory stepFactory = new StepFactory(operators);
    final StringCalculator stringCalculator = new StringCalculator(stepFactory);
    final long result = stringCalculator.calculate(scanner.nextLine());
    System.out.println(result);
  }
}
