package againracing.domain;

import java.util.Set;

@FunctionalInterface
public interface CarFactory {
  Set<Car> create(Set<String> names);
}
