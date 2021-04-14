package againracing.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import lombok.Builder;

public class IO {
  private final Scanner scanner;
  private final PrintStream printStream;

  @Builder
  public IO(InputStream inputStream, OutputStream outputStream) {
    this.scanner = new Scanner(inputStream);
    this.printStream = new PrintStream(outputStream);
  }

  public String nextLine() {
    return scanner.nextLine();
  }

  public void println(String x) {
    printStream.println(x);
  }
}
