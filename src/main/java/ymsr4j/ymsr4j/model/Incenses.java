package ymsr4j.ymsr4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by razon on 15/03/22.
 */
@Data
public class Incenses {
    private List<Incense> incenses;
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("num_pages")
    private Integer numPages;
    @JsonProperty("current_page")
    private Integer currentPage;
    @JsonProperty("next_page")
    private Integer nextPage;
    @JsonProperty("prev_page")
    private Integer prevPage;
}
