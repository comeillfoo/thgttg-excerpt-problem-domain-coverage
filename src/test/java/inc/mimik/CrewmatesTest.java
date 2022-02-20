package inc.mimik;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Tag( "Crewmates" )
public class CrewmatesTest {

  @Test
  public void testCrewmateListen() {
    final Crewmate john = new Crewmate( "Джон" );
    final Crewmate capt = new Crewmate( "Капитан" );
    final Message message = new Message( "Привет, Джон", john, capt );

    capt.send( john, message );

    assertTrue( john.isListened( message ) );
  }

  @Test
  public void testCrewmatesListenTheirsMessage() {
    final Crewmates crewmates = new Crewmates(  );
    final Crewmate capt = new Crewmate( "капитан" );

    for ( char n = 'a'; n <= 'z'; ++n )
      crewmates.employ( new Crewmate( String.valueOf( n ) ) );

    final Message message = new Message( "отпуска отменяются", crewmates, capt );

    capt.send( crewmates, message );

    assertTrue( crewmates.isListened( message ) );
  }

  @Test
  public void testCrewmatesListenToAlienMessage() {
    final Crewmates crewmates = new Crewmates(  );
    final Crewmate capt = new Crewmate( "капитан" );

    for ( char n = 'a'; n <= 'z'; ++n )
      crewmates.employ( new Crewmate( String.valueOf( n ) ) );

    final Crewmate a = crewmates.getCrewmateByName( "a" );

    final Message message = new Message( "отпуска отменяются", a, capt );

    capt.send( crewmates, message );

    assertFalse( crewmates.isListened( message ) );
  }

}
