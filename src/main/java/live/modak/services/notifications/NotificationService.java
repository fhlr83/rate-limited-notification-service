package live.modak.services.notifications;

/**
 * I'm representing a database using map to represented by a map, but it should be a NoSql database using redis for example to define a expiration time to each rule of
 */
public interface NotificationService {
    void send(String user, String message);
    boolean exceededMailLimits(String user);
}
