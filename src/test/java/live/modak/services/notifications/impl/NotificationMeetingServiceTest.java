package live.modak.services.notifications.impl;

import org.junit.jupiter.api.Test;

class NotificationMeetingServiceTest {

    @Test
    void test01() {
        NotificationMeetingService.getInstance().send("user1", "message 1");
        NotificationMeetingService.getInstance().send("user1", "message 2");
        NotificationMeetingService.getInstance().send("user1", "message 3");
    }

}