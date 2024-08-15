package live.modak;

import live.modak.factories.NotificationFactory;
import live.modak.services.enums.EmailTypeEnum;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NotificationFactory notificationFactory = new NotificationFactory();
        notificationFactory.getNotifier(EmailTypeEnum.STATUS).send("user 1", "status 1");
        notificationFactory.getNotifier(EmailTypeEnum.STATUS).send("user 1", "status 2");
        notificationFactory.getNotifier(EmailTypeEnum.STATUS).send("user 1", "status 3");
        notificationFactory.getNotifier(EmailTypeEnum.STATUS).send("user 2", "status 1");
        notificationFactory.getNotifier(EmailTypeEnum.NEWS).send("user", "news 1");
        notificationFactory.getNotifier(EmailTypeEnum.NEWS).send("user", "news 2");
        notificationFactory.getNotifier(EmailTypeEnum.NEWS).send("user 2", "news 1");
        notificationFactory.getNotifier(EmailTypeEnum.NEWS).send("user 2", "news 2");
        notificationFactory.getNotifier(EmailTypeEnum.MARKETING).send("user", "marketing 1");
        notificationFactory.getNotifier(EmailTypeEnum.MARKETING).send("user", "marketing 2");
        notificationFactory.getNotifier(EmailTypeEnum.MARKETING).send("user", "marketing 3");
        notificationFactory.getNotifier(EmailTypeEnum.MARKETING).send("user", "marketing 4");
        notificationFactory.getNotifier(EmailTypeEnum.MEETING).send("user", "meeting 1");
        notificationFactory.getNotifier(EmailTypeEnum.MEETING).send("user", "meeting 2");
        notificationFactory.getNotifier(EmailTypeEnum.UPDATE).send("user", "update 1");
        notificationFactory.getNotifier(EmailTypeEnum.UPDATE).send("user", "update 2");
        notificationFactory.getNotifier(EmailTypeEnum.UPDATE).send("user", "update 3");
        notificationFactory.getNotifier(EmailTypeEnum.UPDATE).send("user", "update 4");
        Thread.sleep(120000);
        notificationFactory.getNotifier(EmailTypeEnum.NEWS).send("user", "news 3");
        notificationFactory.getNotifier(EmailTypeEnum.MARKETING).send("user", "marketing 5");
        notificationFactory.getNotifier(EmailTypeEnum.STATUS).send("user", "status 3");
    }
}