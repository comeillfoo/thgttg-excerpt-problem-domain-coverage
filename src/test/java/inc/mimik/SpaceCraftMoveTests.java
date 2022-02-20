package inc.mimik;

import org.junit.jupiter.api.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@Tag("SpaceCraft")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceCraftMoveTests {
    private static Spacecraft vessel;


    @BeforeEach
    public  void Init() {
        Star before = new Star("Initial star", new ArrayList<>() {{
            add(new Dock("First"));
        }});
        for (Dock e : before.getDocks()) {
            e.setStar(before);
        }
        vessel = new Spacecraft(before, null);
    }

    @Test
    @Order(1)
    @DisplayName("Move to star success")
    public void isSuccessfulMoveToStar() {
        Star after = new Star("Final star", new ArrayList<>() {{
            add(new Dock("First"));
        }});
        for (Dock e : after.getDocks()) {
            e.setStar(after);
        }
        vessel.jumpTo(after);
        assertEquals(after, vessel.getOrbital(), "");
    }

    @Test
    @Order(2)
    @DisplayName("Move to star fail")
    public void isNotSuccessfulMoveToStar() {
        Star after = null;
        assertThrows(NullPointerException.class, () -> {
            vessel.jumpTo(after);
        });
    }

    @Test
    @Order(3)
    @DisplayName("Move to free dock success")
    public void isSuccessfulMoveToDoc() {
        Dock freeDock = new Dock("Free dock");
        Star after = new Star("Final star", new ArrayList<>() {{
            add(freeDock);
        }});
        for (Dock e : after.getDocks()) {
            e.setStar(after);
        }

        vessel.jumpTo(after);
        assertEquals(after, vessel.getOrbital());

        vessel.stop("Preventive examination", 3);
        Stop stop = vessel.getStop();
        assertNotNull(stop);
        assertEquals(stop.getDock(), freeDock);
        assertEquals(stop.getDock().getIsFree(), Boolean.FALSE);


    }

    @Test
    @Order(4)
    @DisplayName("Move to busy dock fail")
    public void isNotSuccessfulMoveToDoc() {
        Dock notFreeDock = new Dock("Not free");
        notFreeDock.setIsFree(Boolean.FALSE);
        Star after = new Star("Final star", new ArrayList<>() {{
            add(notFreeDock);
        }});
        for (Dock e : after.getDocks()) {
            e.setStar(after);
        }

        vessel.jumpTo(after);
        assertEquals(after, vessel.getOrbital());

        vessel.stop("Preventive examination", 3);
        assertNull(vessel.getStop());


    }

    @Test
    @Order(5)
    @DisplayName("Move to dock twice fail")
    public void moveToDockTwice() {
        Dock freeDock = new Dock("Free dock");
        Dock secondFreeDock = new Dock("Second Dock");

        Star after = new Star("Final star", new ArrayList<>() {{
            add(freeDock);
            add(secondFreeDock);
        }});
        for (Dock e : after.getDocks()) {
            e.setStar(after);
        }

        vessel.jumpTo(after);
        assertEquals(after, vessel.getOrbital());
        vessel.stop("Preventive examination", 3);
        Stop stop = vessel.getStop();
        assertNotNull(stop);
        assertEquals(stop.getDock().getIsFree(), Boolean.FALSE);

        vessel.stop("Preventive examination", 3);
        assertNotNull(stop);
        assertEquals(stop, vessel.getStop());
        assertEquals(freeDock.getIsFree() || secondFreeDock.getIsFree(), Boolean.TRUE);


    }

    @Test
    @Order(6)
    @DisplayName("leave dock success")
    public void leaveDock() {
        Dock freeDock = new Dock("Free dock");
        Star after = new Star("Final star", new ArrayList<>() {{
            add(freeDock);
        }});
        for (Dock e : after.getDocks()) {
            e.setStar(after);
        }
        vessel.jumpTo(after);
        vessel.stop("Preventive examination", 0);
        Boolean res = vessel.leave();
        assertEquals(res, Boolean.TRUE);


    }

    @Test
    @Order(7)
    @DisplayName("leave dock fail")
    public void leaveDockFail() {
        Dock freeDock = new Dock("Free dock");
        Star after = new Star("Final star", new ArrayList<>() {{
            add(freeDock);
        }});
        for (Dock e : after.getDocks()) {
            e.setStar(after);
        }
        vessel.jumpTo(after);
        vessel.stop("Preventive examination", 3);
        Boolean res = vessel.leave();
        assertEquals(res, Boolean.FALSE);


    }
}