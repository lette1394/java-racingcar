package racing.runner;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import racing.domain.Names;

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
          .appendText("the game winner are ")
          .appendValue(String.join(", ", gameResult.winner().names()));
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

  static Matcher<GameResult> winnerIs(String... expectedWinnerNames) {
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(GameResult gameResult, Description mismatchDescription) {
        final Names actualWinnerNames = gameResult.winner().names();
        if (actualWinnerNames.equals(new Names(expectedWinnerNames))) {
          return true;
        }

        mismatchDescription
          .appendText("the game winner is(are) ")
          .appendValue(String.join(", ", actualWinnerNames));
        return false;
      }

      @Override
      public void describeTo(Description description) {
        description
          .appendText("the game winner are ")
          .appendValue(expectedWinnerNames);
      }
    };
  }
}
