package againracing.domain;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovementPolicyCarFactory implements CarFactory {
  private final MovementPolicy movementPolicy;

  public Set<Car> create(Set<String> names) {
    final Set<Car> result = new HashSet<>();
    for (String name : names) {
      result.add(create(name));
    }
    return result;
  }

  private Car create(String name) {
    return new Car(name, movementPolicy);
  }
}
