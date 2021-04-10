package racing.runner;

import static racing.Contracts.requires;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import racing.domain.Car;
import racing.domain.Cars;

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

  public Optional<Car> findCarOwnedBy(String name) {
    return lastRound().findCarOwnedBy(name);
  }

  private Cars lastRound() {
    return results.get(rounds() - 1);
  }
}
