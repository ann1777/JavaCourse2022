package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAssignmentForGroup {
    @JsonProperty ("target_type")
    public String targetType;

    @JsonProperty ("student_id")
    public Integer studentId;

    @JsonProperty ("content_id")
    public Integer contentId;

    public CreateAssignmentForGroup(String targetType, Integer studentId, Integer contentId) {
        this.targetType = targetType;
        this.studentId = studentId;
        this.contentId = contentId;
    }

    public CreateAssignmentForGroup() {
    }
}
