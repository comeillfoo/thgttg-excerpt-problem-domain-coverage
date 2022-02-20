package inc.mimik;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
public class Stop {
  // private final Date start;
  // private final Date finish;
  private final String reason;

  @Getter
  @Setter
  private final Dockable vessel;

  @Getter
  @Setter
  private final Dock dock;
}
