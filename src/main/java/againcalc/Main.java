package againcalc;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final StringCalculator stringCalculator = new StringCalculator();
    final long result = stringCalculator.calculate(scanner.nextLine());
    System.out.println(result);
  }
}
