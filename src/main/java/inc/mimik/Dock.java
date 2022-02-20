package inc.mimik;

import lombok.Getter;
import lombok.Setter;


public class Dock {
  //private final Port port;

  @Getter
  @Setter
  private  Star star;

  @Getter
  private final String name;

  @Getter
  @Setter
  private Boolean isFree = Boolean.TRUE;

  public Dock(String name) {
    this.name = name;
  }


}
