package ymsr4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import ymsr4j.ymsr4j.http.HttpClient;
import ymsr4j.ymsr4j.http.HttpResponse;
import ymsr4j.ymsr4j.model.Incenses;
import ymsr4j.ymsr4j.model.Users;

import java.io.IOException;

/**
 * Created by razon on 15/03/14.
 */
public class Ymsr {
    private static final String API_ROOT = "http://haka.yamashi.ro/api/v1/";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Incenses incenses(int page) throws IOException {
        HttpResponse response = HttpClient.get(API_ROOT + "incenses?page=" + page);
        return MAPPER.readValue(response.getHttpResponse(), Incenses.class);
    }

    public static int incenses(String token) throws IOException {
        HttpResponse response = HttpClient.post(API_ROOT + "incenses", "token=" + token);
        return response.getHttpResponseCode();
    }

    public static Users users(String nickname) throws IOException {
        HttpResponse response = HttpClient.get(API_ROOT + "users/" + nickname);
        return MAPPER.readValue(response.getHttpResponse(), Users.class);
    }

    public static Incenses usersIncenses(String nickname) throws IOException {
        HttpResponse response = HttpClient.get(API_ROOT + "users/" + nickname + "/incenses");
        return MAPPER.readValue(response.getHttpResponse(), Incenses.class);
    }
}
