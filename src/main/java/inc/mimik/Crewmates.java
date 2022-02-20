package inc.mimik;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Crewmates implements Addressee {
  private List<Crewmate> crewmates = new ArrayList<>(  );

  @Override
  public void receive( Message message ) {
    if ( message.ADDRESSEE != this ) return;

    for ( Crewmate c : crewmates )
      c.listen( message );
  }

  public boolean employ( Crewmate c ) {
    return crewmates.add( c );
  }

  public boolean isListened( Message message ) {
    for ( Crewmate c : crewmates )
      if ( !c.isListened( message ) )
        return false;
    return true;
  }

  public Crewmate getCrewmateByName( String name ) {
    Optional<Crewmate> maybeCrewmate = crewmates.stream( ).filter( ( c ) -> ( c.getName().equals( name ) ) ).findAny();
    return maybeCrewmate.orElse( null );
  }
}
