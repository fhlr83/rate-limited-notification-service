package live.modak.factories;

import live.modak.services.enums.EmailTypeEnum;
import live.modak.services.notifications.impl.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    @DisplayName("Getting marketing notifier")
    void test01() {
        assertEquals(new NotificationFactory().getNotifier(EmailTypeEnum.MARKETING).getClass(), NotificationMarketingService.class);
    }
    @Test
    @DisplayName("Getting Meeting notifier")
    void test02() {
        assertEquals(new NotificationFactory().getNotifier(EmailTypeEnum.MEETING).getClass(), NotificationMeetingService.class);
    }

    @Test
    @DisplayName("Getting News notifier")
    void test03() {
        assertEquals(new NotificationFactory().getNotifier(EmailTypeEnum.NEWS).getClass(), NotificationNewsService.class);
    }

    @Test
    @DisplayName("Getting Status notifier")
    void test04() {
        assertEquals(new NotificationFactory().getNotifier(EmailTypeEnum.STATUS).getClass(), NotificationStatusService.class);
    }

    @Test
    @DisplayName("Getting Update notifier")
    void test05() {
        assertEquals(new NotificationFactory().getNotifier(EmailTypeEnum.UPDATE).getClass(), NotificationUpdateService.class);
    }

    @Test
    @DisplayName("Getting a non expected parameter.")
    void test06() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> new NotificationFactory().getNotifier(EmailTypeEnum.INVALID));
        assertEquals("The email type was not implemented yet. Contact the Administrator.", e.getMessage());

    }

    @Test
    @DisplayName("Getting nothing passing a null notifier")
    void test07() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> new NotificationFactory().getNotifier(null));

        assertEquals("The parameter emailTypeEnum is invalid.", e.getMessage());
    }

}