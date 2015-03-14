package ymsr4j;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by razon on 15/03/14.
 */
public class Ymsr {
    private static final String API_ROOT = "http://haka.yamashi.ro/api/v1/";

    public static int incenses(String token) throws IOException {
        URL url = new URL(API_ROOT + "incenses");
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(),
                    StandardCharsets.UTF_8))) {
                writer.write("token=");
                writer.write(token);
                writer.flush();
            }

            return connection.getResponseCode();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
