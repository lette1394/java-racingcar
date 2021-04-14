package againracing.runner;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  public void typeCarNames(String carNames) {
    outputStream.writeBytes(carNames.getBytes(StandardCharsets.UTF_8));
  }

  public void typeTryTimes(int count) {
    outputStream.writeBytes(Integer.toString(count).getBytes(StandardCharsets.UTF_8));
  }

  public void enter() {
    outputStream.writeBytes("\n".getBytes(StandardCharsets.UTF_8));
  }

  public String toUserInputString() {
    return outputStream.toString(StandardCharsets.UTF_8);
  }
}
