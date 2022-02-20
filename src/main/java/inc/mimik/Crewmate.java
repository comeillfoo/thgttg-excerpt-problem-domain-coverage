package inc.mimik;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Crewmate implements Listenable, Addressee, Addresser {
  @Getter
  private final String name;

  private final Map<Message, Boolean> isMessageListened = new HashMap<>(  );

  @Override
  public void listen( Message message ) {
    isMessageListened.put( message, true );
  }

  public boolean isListened( Message message ) {
    return isMessageListened.getOrDefault( message, false );
  }

  @Override
  public void receive( Message message ) {
    if ( message.ADDRESSEE != this ) return;
    listen( message );
  }

  @Override
  public void send( Addressee addressee, Message message ) {
    addressee.receive( message );
  }
}
