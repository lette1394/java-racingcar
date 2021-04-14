package againracing.view;

import java.util.List;

@FunctionalInterface
public interface PrinterFactory {
  Printer create(List<String> namesOrder);
}
