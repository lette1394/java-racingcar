package againracing.domain;

@FunctionalInterface
public interface MovementPolicy {
  Movement next();
}