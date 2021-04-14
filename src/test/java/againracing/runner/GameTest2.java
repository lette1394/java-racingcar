package againracing.runner;

import static common.TestFixtures.anyPositiveIntAtLeast;
import static common.TestFixtures.anyPositiveLongAtMost;
import static org.hamcrest.MatcherAssert.assertThat;
import static againracing.domain.CarFixtures.anyCars;
import static againracing.runner.GameResultMatchers.winnersAre;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import againracing.domain.Car;
import againracing.domain.Game;
import againracing.domain.GameResult;

public class GameTest2 {
  int winningLocation;

  @BeforeEach
  void beforeEach() {
    winningLocation = anyPositiveIntAtLeast(2);
  }

  @Test
  void test1() {
    final Set<Car> shouldBeWinners = anyCars(winningLocation);
    final Set<Car> shouldBeLosers = anyCars(anyPositiveLongAtMost(winningLocation));
    final Set<Car> allParticipants = Stream.concat(shouldBeWinners.stream(), shouldBeLosers.stream())
      .collect(Collectors.toSet());

    final Game game = Game.builder()
      .tries(winningLocation)
      .cars(allParticipants)
      .build();
    final GameResult gameResult = game.run();

    assertThat(gameResult, winnersAre(shouldBeWinners));
  }
}
