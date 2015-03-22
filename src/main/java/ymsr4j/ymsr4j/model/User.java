package ymsr4j.ymsr4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by razon on 15/03/22.
 */
@Data
public class User {
    private String name;
    private String nickname;
    private String image;
    @JsonProperty("created_at")
    private Date createdAt;
}
