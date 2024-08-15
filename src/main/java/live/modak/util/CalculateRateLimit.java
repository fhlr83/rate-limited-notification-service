package live.modak.util;

import java.time.LocalDateTime;

public class CalculateRateLimit {

    public static Boolean isExceedTime(LocalDateTime registry, Long estimativeInMinutes) {
        LocalDateTime now = LocalDateTime.now().minusMinutes(estimativeInMinutes);
        return registry.isAfter(now);
    }
}
