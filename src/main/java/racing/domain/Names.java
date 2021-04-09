package racing.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Names implements Iterable<String> {
  private final List<Name> names;

  public static Names names(String[] names) {
    return new Names(Arrays.stream(names)
      .map(Name::new)
      .collect(Collectors.toList()));
  }

  @Override
  public Iterator<String> iterator() {
    return names.stream().map(Name::toString).iterator();
  }

  public int size() {
    return names.size();
  }
}
