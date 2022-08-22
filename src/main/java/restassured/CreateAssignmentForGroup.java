package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAssignmentForGroup {
    @JsonProperty
    public String target_type;

    @JsonProperty
    public Integer student_id;

    @JsonProperty
    public Integer content_id;

    public CreateAssignmentForGroup(String target_type, Integer student_id, Integer content_id) {
        this.target_type = target_type;
        this.student_id = student_id;
        this.content_id = content_id;
    }

    public CreateAssignmentForGroup() {
    }
}
