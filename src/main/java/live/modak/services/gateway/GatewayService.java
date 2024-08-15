package live.modak.services.gateway;

public class GatewayService {

    private static GatewayService INSTANCE;

    public static GatewayService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GatewayService();
        }
        return INSTANCE;
    }

    public void send(String userId, String message) {
        System.out.println(String.format("sending message '%s' to user %s.", message, userId));
    }
}
