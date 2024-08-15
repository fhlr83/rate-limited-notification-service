package live.modak.services.notifications.impl;

import live.modak.services.gateway.GatewayService;
import live.modak.services.notifications.NotificationService;

/**
 * Notification update have no rule to rate a limit of notification but should be implemented any time.
 */
public class NotificationUpdateService implements NotificationService {
    private static NotificationUpdateService INSTANCE;

    protected NotificationUpdateService() {

    }
    public static NotificationService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new NotificationUpdateService();
        }
        return INSTANCE;
    }

    @Override
    public void send(String user, String message) {
        GatewayService.getInstance().send(user, message);
    }


    @Override
    public boolean exceededMailLimits(String user) {
        return true;
    }
}
