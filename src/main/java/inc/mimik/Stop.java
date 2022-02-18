package inc.mimik;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Stop {
  private final Date start;
  private final Date finish;
  private final String reason;

  private final Dockable vessel;

  private final Dock dock;
}
