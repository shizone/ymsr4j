package ymsr4j.ymsr4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by razon on 15/03/22.
 */
@Data
public class Incense {
    @JsonProperty("created_at")
    private String createdAt;
    private User user;
}
