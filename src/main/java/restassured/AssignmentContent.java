package restassured;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentContent {
    @JsonProperty
    public String content;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public Integer id;

    public AssignmentContent() {
    }

    public AssignmentContent(String content) {
        this.content = content;
    }
}
