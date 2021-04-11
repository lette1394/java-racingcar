package racing.domain;

import static racing.Contracts.requires;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameResult {
  private final List<Cars> results;

  public int rounds() {
    return results.size();
  }

  public Stream<Cars> carsStream() {
    return results.stream();
  }

  public Optional<Car> soleWinner() {
    return lastRound().soleWinner();
  }

  public Cars winners() {
    requires(results.size() > 0, "results.size() > 0");
    return lastRound().winners();
  }

  private Cars lastRound() {
    return results.get(rounds() - 1);
  }
}
