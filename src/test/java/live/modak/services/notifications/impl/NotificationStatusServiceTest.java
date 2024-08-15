package live.modak.services.notifications.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationStatusServiceTest {

    @Test
    void test01() {
        NotificationStatusService.getInstance().send("user-test", "message1");
        NotificationStatusService.getInstance().send("user-test", "message2");
        NotificationStatusService.getInstance().send("user-test", "message3");
        NotificationStatusService.getInstance().send("user-test", "message4");
        NotificationStatusService.getInstance().send("user-test", "message5");
    }

}