import client.NormalClient;
import org.junit.Test;

import java.io.IOException;

public class PersistentConnectionTest {
    private String host = "127.0.0.1";
    private int port = 8888;
    private NormalClient client = new NormalClient(port, host);

    private void sendRequest(String uri, boolean isPersistent) throws IOException {
        client.Get(uri, isPersistent);
    }

    @Test
    public void persistentConnectionTest() throws IOException {
        String uri = "/index.html";
        sendRequest(uri, true);
        sendRequest(uri, true);
        sendRequest(uri, true);
    }
    @Test
    public void RedirectTest() throws IOException {
        String uri = "/301origin.html";
        sendRequest(uri, true);
        uri="/302origin.html";
        sendRequest(uri, true);
        
    }
}
