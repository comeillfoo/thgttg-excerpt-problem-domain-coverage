package inc.mimik;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Star {

  @Getter
  private final String NAME;

  @Getter
  private final List<Dock> docks;

}
