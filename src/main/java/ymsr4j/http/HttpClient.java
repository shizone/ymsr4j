package ymsr4j.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by razon on 15/03/22.
 */
public class HttpClient {
    public static HttpResponse get(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            return httpResponse(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static HttpResponse post(String urlString, String parameter) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(),
                        StandardCharsets.UTF_8));
                writer.write(parameter);
                writer.flush();
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }

            return httpResponse(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static HttpResponse httpResponse(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStreamReader isr = null;
            BufferedReader reader = null;
            try {
                isr = new InputStreamReader(connection.getInputStream(),
                        StandardCharsets.UTF_8);
                reader = new BufferedReader(isr);
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (isr != null) {
                    isr.close();
                }
            }
        }
        return new HttpResponse(responseCode, response.toString());
    }
}
