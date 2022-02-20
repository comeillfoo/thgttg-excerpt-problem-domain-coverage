package inc.mimik;

import org.junit.jupiter.api.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@Tag("SpaceCraft")
public class SpaceCraftMoveTests {
    private static Spacecraft vessel;

    @Test
    @BeforeAll
    public static void isSuccessfulInit() {

        Star before = new Star("Initial star", new ArrayList<Dock>() {{
            add(new Dock("First"));
        }});
        for (Dock e : before.getDocks()) {
            e.setStar(before);
        }

        vessel = new Spacecraft(before);
        assertEquals(before, vessel.getOrbital());
    }

    @Test
    @Order(1)
    @DisplayName("Move to star")
    public void isSuccessfulMoveToStar() {

        Star after = new Star("Final star", new ArrayList<Dock>() {{
            add(new Dock("First"));
        }});
        vessel.jumpTo(after);
        assertEquals(after, vessel.getOrbital());


    }

    @Test
    @Order(2)
    @DisplayName("Move to free dock")
    public void isSuccessfulMoveToDoc() {
        Dock freeDock = new Dock("Free dock");
        Star after = new Star("Final star", new ArrayList<Dock>() {{
            add(freeDock);
        }});
        vessel.jumpTo(after);
        assertEquals(after, vessel.getOrbital());

        Stop stop = vessel.stop("Preventive examination");
        assertNotNull(stop);
        assertEquals(stop.getDock(), freeDock);
        assertEquals(stop.getDock().getIsFree(), Boolean.FALSE);
    }

    @Test
    @Order(3)
    @DisplayName("Move to busy dock")
    public void isNotSuccessfulMoveToDoc() {
        Dock notFreeDock = new Dock("Not free");
        notFreeDock.setIsFree(Boolean.FALSE);
        Star after = new Star("Final star", new ArrayList<Dock>() {{
            add(notFreeDock);
        }});
        vessel.jumpTo(after);
        assertEquals(after, vessel.getOrbital());

        Stop stop = vessel.stop("Preventive examination");
        assertNull(stop);
    }
}
