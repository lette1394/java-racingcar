package againracing;

import java.util.stream.Stream;
import lombok.experimental.Delegate;

public abstract class BaseStream<T> implements Stream<T> {
  @Delegate
  private final Stream<T> delegate;

  protected BaseStream(Stream<T> delegate) {
    this.delegate = delegate;
  }
}
