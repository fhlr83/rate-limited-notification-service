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
 * Notification marketing will have rule to send only 3 messages per hour.
 */
public class NotificationMarketingService implements NotificationService {
    private Map<String, List<LocalDateTime>> temporaryDb = new HashMap<>();
    private static final Long LIMIT_TIME = 60L;
    private static NotificationMarketingService INSTANCE;

    protected NotificationMarketingService() {

    }

    public static NotificationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NotificationMarketingService();
        }
        return INSTANCE;
    }

    @Override
    public void send(String user, String message) {
        if (temporaryDb.containsKey(user)) {
            if (exceededMailLimits(user)) {
                System.out.println(String.format("The number of marketing emails has been exceeded for the user %s. (3 per hour)", user));
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
        ).count() >= 3;
    }
}
