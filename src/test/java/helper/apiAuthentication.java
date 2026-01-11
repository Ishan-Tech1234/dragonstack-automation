package helper;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.cookie.Cookie;
import org.apache.hc.client5.http.cookie.SetCookie;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;



import java.io.Closeable;
import java.io.IOException;

import static org.apache.hc.client5.http.classic.HttpClient.*;


public class apiAuthentication{
    public static void main(String[] args){
        fetchData();
    }
    public static String fetchData() {
       String cookieString="";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpUriRequest request = new HttpPost("http://localhost:3000/account/login");
            request.setHeader("Content-Type", "application/json");
            String inputJson = "{"
                    + "\"username\": \"manish123\","
                    + "\"password\": \"manish123\""
                    + "}";
            StringEntity entity = new StringEntity(inputJson);
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            Header[] headers = response.getHeaders("Set-Cookie");

            for (Header header : headers) {
                String headerValue = header.getValue();
                // sessionString=VALUE; Path=/; Expires=...
                if (headerValue.startsWith("sessionString=")) {
                    return headerValue.split(";", 2)[0].split("=", 2)[1];
                }
            }

            throw new RuntimeException("sessionString cookie not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cookieString;
    }

}
