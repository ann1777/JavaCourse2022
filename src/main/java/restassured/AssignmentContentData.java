package restassured;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentContentData {
    @JsonProperty
    public String content;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public Integer id;

    public AssignmentContentData(String student1, String id, String create_api_test_framework) {}

    public AssignmentContentData(String content) {
        this.content = content;
    }
}
