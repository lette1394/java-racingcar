package againracing.view;

import java.util.List;

public final class Printers {
  public static Printer finalWinner(List<String> namesOrder) {
    return new FinalWinnerPrinter(namesOrder);
  }

  public static Printer carHistory(List<String> namesOrder) {
    return new CarHistoryPrinter(namesOrder);
  }

  public static Printer lineBreak(int count) {
    return new LineBreakPrinter(count);
  }

  public static Printer sequence(List<Printer> printers) {
    return new SequencePrinter(printers);
  }
}
