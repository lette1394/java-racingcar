package racing;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class CarAssertions {
  public static Matcher<Car> movedExactly(long times) {
    return new TypeSafeDiagnosingMatcher<>() {
      @Override
      protected boolean matchesSafely(Car item, Description mismatchDescription) {
        if (item.location() == times) {
          return true;
        }
        mismatchDescription
          .appendText("a car at ")
          .appendValue(item.location());
        return false;
      }

      @Override
      public void describeTo(Description description) {
        description
          .appendText("a car at ")
          .appendValue(times);
      }
    };
  }

  public static Matcher<Car> didntMoveAtAll() {
    return movedExactly(0);
  }
}
