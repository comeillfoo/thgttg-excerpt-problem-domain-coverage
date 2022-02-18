package inc.mimik;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Message {
  public final String TEXT;

  public final Addressee ADDRESSEE;
  public final Addresser ADDRESSER;
}
