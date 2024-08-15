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
 * Notification meeting will have rule to send only 1 messages each 12 hours.
 *
 */
public class NotificationMeetingService implements NotificationService {
    private static NotificationMeetingService INSTANCE;
    private Map<String, List<LocalDateTime>> temporaryDb = new HashMap<>();
    private static final Long LIMIT_TIME = 720L;

    protected NotificationMeetingService() {
    }

    public static NotificationService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new NotificationMeetingService();
        }
        return INSTANCE;
    }

    @Override
    public void send(String user, String message) {
        if (temporaryDb.containsKey(user)) {
            if (exceededMailLimits(user)) {
                System.out.println(String.format("The number of meetings emails has been exceeded for the user %s. (1 each 12 hours)", user));
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
        return temporaryDb.get(user).stream().anyMatch(ldt ->
                CalculateRateLimit.isExceedTime(ldt, LIMIT_TIME));
    }
}
