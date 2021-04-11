package racing.domain;

@FunctionalInterface
public interface MovementPolicy {
  Movement next();
}
