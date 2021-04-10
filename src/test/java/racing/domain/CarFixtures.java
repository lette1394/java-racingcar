package racing.domain;

import static common.TestFixtures.anyNonBlankStringWithLength;
import static common.TestFixtures.anyPositiveInt;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Builder;

public class CarFixtures {
  public static MovementPolicy alwaysForward() {
    return () -> Movement.FORWARD;
  }

  public static MovementPolicy alwaysStay() {
    return () -> Movement.STAY;
  }

  public static Car aCarWith(MovementPolicy movementPolicy) {
    return new Car(randomName(), movementPolicy);
  }

  public static String randomName() {
    return anyNonBlankStringWithLength(5);
  }

  @Builder(builderMethodName = "aCar", builderClassName = "AtMostBuilder")
  public static Car AtMostBuilder(String hasName, long canGoForwardAtMost) {
    return new Car(hasName, new MaximumLocationPolicy(canGoForwardAtMost));
  }

  public static Set<Car> anyCars(long locationAtMost) {
    return IntStream.range(0, anyPositiveInt(1, 10))
      .mapToObj(__ -> CarFixtures.aCar()
        .hasName(randomName())
        .canGoForwardAtMost(locationAtMost)
        .build())
      .collect(Collectors.toUnmodifiableSet());
  }
}
