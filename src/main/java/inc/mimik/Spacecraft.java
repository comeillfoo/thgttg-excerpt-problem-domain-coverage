package inc.mimik;

import lombok.Getter;

import java.util.List;

public class Spacecraft implements Dockable, Hyperleapable {
  private Cargo cargo;

  private List<Crewmate> crewmates;

  @Getter
  private Star orbital;

  @Override
  public void jumpTo( Star star ) {
    orbital = star;
  }
}
