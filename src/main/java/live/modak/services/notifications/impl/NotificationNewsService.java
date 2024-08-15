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
 * Notification news will have rule to send only 1 messages per day.
 */
public class NotificationNewsService implements NotificationService {
    private final Map<String, List<LocalDateTime>> temporaryDb = new HashMap<>();
    private static final Long LIMIT_TIME = 1440L;

    protected NotificationNewsService() {

    }

    private static NotificationNewsService INSTANCE;
    @Override
    public void send(String user, String message) {
        if (temporaryDb.containsKey(user)) {
            if (exceededMailLimits(user)) {
                System.out.println(String.format("The number of news emails has been exceeded for the user %s. (1 per day)", user));
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

    public static NotificationService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new NotificationNewsService();
        }
        return INSTANCE;
    }
}
