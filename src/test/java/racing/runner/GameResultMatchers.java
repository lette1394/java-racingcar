package racing.runner;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import racing.domain.Car;

public class GameResultMatchers {
  static Matcher<GameResult> winnerIs(String winnerName) {
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(GameResult item, Description mismatchDescription) {
        final Set<String> winnerNames = item.winner()
          .stream()
          .map(Car::name)
          .collect(Collectors.toSet());

        if (winnerNames.size() == 1 && winnerNames.contains(winnerName)) {
          return true;
        }

        mismatchDescription
          .appendText("the game winner are ")
          .appendValue(String.join(", ", winnerNames));
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

  static Matcher<GameResult> winnerIs(String... winnerNames) {
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(GameResult item, Description mismatchDescription) {
        final Set<String> candidates = Arrays.stream(winnerNames).collect(Collectors.toSet());
        final Set<String> winnerNames = item.winner()
          .stream()
          .map(Car::name)
          .collect(Collectors.toSet());

        if (winnerNames.size() == candidates.size() && winnerNames.containsAll(candidates)) {
          return true;
        }

        mismatchDescription
          .appendText("the game winner is(are) ")
          .appendValue(String.join(", ", winnerNames));
        return false;
      }

      @Override
      public void describeTo(Description description) {
        description
          .appendText("the game winner are ")
          .appendValue(winnerNames);
      }
    };
  }
}
