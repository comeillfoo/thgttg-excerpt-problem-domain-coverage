package inc.mimik;

public interface Dockable {
    void stop(String reason, int days);
    Boolean leave();
}
