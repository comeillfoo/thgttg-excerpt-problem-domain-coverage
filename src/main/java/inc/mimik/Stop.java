package inc.mimik;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Calendar;


@AllArgsConstructor
public class Stop {
    @Getter
    private final Calendar start;

    @Getter
    private final Calendar finish;

    @Getter
    private final String reason;

    @Getter
    private final Dockable vessel;

    @Getter
    private final Dock dock;
}
