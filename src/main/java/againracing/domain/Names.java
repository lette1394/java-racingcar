package againracing.domain;

import static java.util.stream.Collectors.toUnmodifiableSet;
import static againracing.Contracts.requires;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import lombok.EqualsAndHashCode;
import againracing.BaseStream;

@EqualsAndHashCode(callSuper = false)
public class Names extends BaseStream<String> implements Iterable<String> {
  private final Set<Name> names;

  public Names(String... names) {
    this(List.of(names));
  }

  public Names(Collection<String> names) {
    super(names.stream());
    final Set<Name> collected = names.stream()
      .map(Name::of)
      .collect(toUnmodifiableSet());

    requires(names.size() > 0, "names.size() > 0");
    requires(collected.size() == names.size(), "collected.size() == names.size()");

    this.names = collected;
  }

  @Override
  public String toString() {
    return names.toString();
  }
}