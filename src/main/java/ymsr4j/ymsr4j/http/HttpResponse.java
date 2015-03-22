package ymsr4j.ymsr4j.http;

import lombok.Value;

/**
 * Created by razon on 15/03/22.
 */
@Value
public class HttpResponse {
    private int httpResponseCode;
    private String httpResponse;
}
