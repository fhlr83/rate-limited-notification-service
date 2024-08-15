package live.modak.services.notifications.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationMarketingServiceTest {
    @Test
    public void test01() {
        NotificationMarketingService.getInstance().send("user-test", "message1");
        NotificationMarketingService.getInstance().send("user-test", "message2");
        NotificationMarketingService.getInstance().send("user-test", "message3");
        NotificationMarketingService.getInstance().send("user-test", "message4");

    }
}