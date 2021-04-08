package step1;

import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Locations {
  private final List<Location> locations;

  public Stream<Location> stream() {
    return locations.stream();
  }
}
