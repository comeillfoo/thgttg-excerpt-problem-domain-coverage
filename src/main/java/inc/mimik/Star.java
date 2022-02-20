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

//  public final double DECLINATION;
//  public final double RIGHT_ASCENSION;
//  public final double WEIGHT;
//  public final double RADIUS;
//  public final double TEMPERATURE;
//  public final double LUMINOSITY;

}
