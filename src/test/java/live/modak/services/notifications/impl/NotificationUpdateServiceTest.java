package live.modak.services.notifications.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationUpdateServiceTest {

    @Test
    @DisplayName("testing a send to notification update.")
    public void test01() {
        NotificationUpdateService.getInstance().send("user-test", "test 1");
    }

    @Test
    @DisplayName("Testing exceeding limits")
    public void test02() {
        assertTrue(NotificationUpdateService.getInstance().exceededMailLimits("user-test"));
    }



}