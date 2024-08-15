package live.modak.factories;

import live.modak.services.notifications.NotificationService;
import live.modak.services.enums.EmailTypeEnum;
import live.modak.services.notifications.impl.*;

public class NotificationFactory {

    public NotificationService getNotifier(EmailTypeEnum emailTypeEnum) {

        if(emailTypeEnum == null) {
            throw new RuntimeException("The parameter emailTypeEnum is invalid.");
        }

        switch (emailTypeEnum) {
            case NEWS -> {
                return NotificationNewsService.getInstance();
            }
            case MEETING -> {
                return NotificationMeetingService.getInstance();
            }
            case UPDATE -> {
                return NotificationUpdateService.getInstance();
            }
            case STATUS -> {
                return NotificationStatusService.getInstance();
            }
            case MARKETING -> {
                return NotificationMarketingService.getInstance();
            }
        }

        throw new RuntimeException("The email type was not implemented yet. Contact the Administrator.");
    }
}
