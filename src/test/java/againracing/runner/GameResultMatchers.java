package againracing.runner;

import java.util.Optional;
import java.util.Set;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import againracing.domain.Car;
import againracing.domain.Cars;
import againracing.domain.GameResult;
import againracing.domain.Names;

public class GameResultMatchers {
  static Matcher<GameResult> winnerIs(String winnerName) {
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(GameResult gameResult, Description mismatchDescription) {
        final boolean condition = gameResult.soleWinner()
          .filter(car -> car.name().equals(winnerName))
          .isPresent();
        if (condition) {
          return true;
        }

        mismatchDescription
          .appendText("the game winners are ")
          .appendValue(String.join(", ", gameResult.winners().names()));
        return false;
      }

      @Override
      public void describeTo(Description description) {
        description
          .appendText("the game winner is ")
          .appendValue(winnerName);
      }
    };
  }

  static Matcher<GameResult> winnersAre(String... expectedWinnerNames) {
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(GameResult gameResult, Description mismatchDescription) {
        final Names actualWinnerNames = gameResult.winners().names();
        if (actualWinnerNames.equals(new Names(expectedWinnerNames))) {
          return true;
        }

        mismatchDescription
          .appendText("the game winner(s) is(are) ")
          .appendValue(String.join(", ", actualWinnerNames));
        return false;
      }

      @Override
      public void describeTo(Description description) {
        description
          .appendText("the game winners are ")
          .appendValue(expectedWinnerNames);
      }
    };
  }

  static Matcher<GameResult> winnersAre(Car... expectedWinners) {
    return winnersAre(Set.of(expectedWinners));
  }

  static Matcher<GameResult> winnersAre(Set<Car> expectedWinners) {
    final Cars cars = new Cars(expectedWinners);
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(GameResult gameResult, Description mismatchDescription) {
        final Cars winners = gameResult.winners();
        if (winners.equals(cars)) {
          return true;
        }

        mismatchDescription
          .appendText("the game winner(s) is(are) ")
          .appendValue(winners.toString());
        return false;
      }

      @Override
      public void describeTo(Description description) {
        description
          .appendText("the game winners are ")
          .appendValue(cars.toString());
      }
    };
  }

  static Matcher<Optional<Car>> locatedAt(long expectedLocation) {
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(Optional<Car> item, Description mismatchDescription) {
        if (item.filter(car -> car.location() == expectedLocation).isPresent()) {
          return true;
        }

        mismatchDescription
          .appendText("a car at ")
          .appendValue(item.isPresent() ? item.get().location() : "<none>");
        return false;
      }

      @Override
      public void describeTo(Description description) {
        description
          .appendText("a car at ")
          .appendValue(expectedLocation);
      }
    };
  }
}
