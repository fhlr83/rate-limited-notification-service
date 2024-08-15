package live.modak.services.notifications.impl;

import live.modak.services.gateway.GatewayService;
import live.modak.services.notifications.NotificationService;
import live.modak.util.CalculateRateLimit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Notification status will have rule to send only 3 messages per hour.
 */
public class NotificationStatusService implements NotificationService {
    private final Map<String, List<LocalDateTime>> temporaryDb = new HashMap<>();
    private static final Long LIMIT_TIME = 1L;
    private static NotificationStatusService INSTANCE;

    protected NotificationStatusService() {

    }

    public static NotificationService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new NotificationStatusService();
        }
        return INSTANCE;
    }

    @Override
    public void send(String user, String message) {
        if (temporaryDb.containsKey(user)) {
            if (exceededMailLimits(user)) {
                System.out.println(String.format("The number of status emails has been exceeded for the user %s. (2 per minute)", user));
                return;
            }
            GatewayService.getInstance().send(user, message);
            temporaryDb.get(user).add(LocalDateTime.now());
        } else {
            GatewayService.getInstance().send(user, message);
            temporaryDb.put(user, new ArrayList<>(List.of(LocalDateTime.now())));
        }
    }

    @Override
    public boolean exceededMailLimits(String user) {
        return temporaryDb.get(user).stream().filter(ldt ->
                CalculateRateLimit.isExceedTime(ldt, LIMIT_TIME)
        ).count() > 2;
    }
}
