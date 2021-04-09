package racing.domain;

import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Locations {
  private final List<Location> locations;

  public Stream<Long> stream() {
    return locations.stream().map(Location::getValue);
  }
}
