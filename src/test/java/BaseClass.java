import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClass {
    protected static ConfigReader configReader = ConfigReader.getInstance();
    protected static final String BASE_ENDPOINT = configReader.getBaseEndpoint();

    protected CloseableHttpClient client;
    protected CloseableHttpResponse response;

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResource() throws IOException {
        if (client != null) {
            client.close();
        }

        if (response != null) {
            response.close();
        }
    }
}
