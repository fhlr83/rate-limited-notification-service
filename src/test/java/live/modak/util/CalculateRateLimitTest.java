package live.modak.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CalculateRateLimitTest {

    @Test
    @DisplayName("is registryTime is before 60 minutes the stipulated time.")
    void test01() {

        LocalDateTime registryTime = LocalDateTime.now().minusMinutes(55);

        assertTrue(CalculateRateLimit.isExceedTime(registryTime, 60L));
    }

    @Test
    @DisplayName("is registryTime is after the stipulated time.")
    void test02() {

        LocalDateTime registryTime = LocalDateTime.now().minusMinutes(65);

        assertFalse(CalculateRateLimit.isExceedTime(registryTime, 60L));
    }

}