package live.modak.services.gateway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GatewayServiceTest {

    @Test
    @DisplayName("Testing sending message mock.")
    void test01() {
        GatewayService.getInstance().send("user1", "message 1");
    }

}