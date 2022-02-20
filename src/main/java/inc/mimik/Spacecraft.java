package inc.mimik;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Spacecraft implements Dockable, Hyperleapable {

    //private Cargo cargo;
    //private List<Crewmate> crewmates;

    @Getter
    private Star orbital;

    @Override
    public void jumpTo(Star star) {
        orbital = star;
    }

    @Override
    public Stop stop(String reason) {
        for (Dock e : orbital.getDocks()) {
            if (e.getIsFree() == Boolean.TRUE) {
                e.setIsFree(Boolean.FALSE);
                return new Stop(reason, this, e);
            }
        }

        return null;
    }

}
