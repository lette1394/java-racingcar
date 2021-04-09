package racing.domain;

import static java.util.stream.Collectors.toUnmodifiableSet;
import static racing.Contracts.requires;

import java.util.Collection;
import java.util.Set;
import racing.BaseStream;

class Names extends BaseStream<String> {
  private final Set<Name> names;

  public Names(Collection<String> names) {
    super(names.stream());

    final Set<Name> collected = names.stream()
      .map(Name::new)
      .collect(toUnmodifiableSet());

    requires(names.size() > 0, "names.size() > 0");
    requires(collected.size() == names.size(), "collected.size() == names.size()");

    this.names = collected;
  }
}
