package inc.mimik;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.GregorianCalendar;


@AllArgsConstructor
public class Spacecraft implements Dockable, Hyperleapable {

    @Getter
    private Star orbital;

    @Getter
    @Setter
    private Stop stop;

    public Boolean leave() {
        if(stop == null) {
            return Boolean.TRUE;
        }
        Calendar now = new GregorianCalendar();
        if(stop.getFinish().after(now)) {
            return Boolean.FALSE;
        }
        stop.getDock().setIsFree(Boolean.TRUE);
        stop = null;
        return Boolean.TRUE;
    }

    @Override
    public void jumpTo(Star star) throws NullPointerException {
        if (star == null) {
            throw new NullPointerException();
        }
        if(stop == null) {
            orbital = star;
            return;
        }
        if(leave()) {
            orbital = star;
        }
    }

    @Override
    public void stop(String reason, int days) {
        if (stop == null) {
            for (Dock e : orbital.getDocks()) {
                if (e.getIsFree() == Boolean.TRUE) {
                    e.setIsFree(Boolean.FALSE);
                    Calendar from = new GregorianCalendar();
                    Calendar to = new GregorianCalendar();
                    to.add(Calendar.DAY_OF_YEAR, days);
                    stop = new Stop(from, to, reason, this, e);
                    break;
                }
            }
        }
    }

}
