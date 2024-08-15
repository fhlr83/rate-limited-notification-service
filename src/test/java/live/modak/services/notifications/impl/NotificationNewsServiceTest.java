package live.modak.services.notifications.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationNewsServiceTest {

    @Test
    void test() {
        NotificationNewsService.getInstance().send("user", "message 1");
        NotificationNewsService.getInstance().send("user", "message 2");
    }

}