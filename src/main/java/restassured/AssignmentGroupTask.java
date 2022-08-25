package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentGroupTask {

    @JsonProperty("target_type")
    public String target;

    @JsonProperty("group_id")
    public Integer groupId;

    @JsonProperty("content_id")
    public Integer contentId;


    public AssignmentGroupTask() {
    }

    public AssignmentGroupTask(String target, Integer groupId, Integer contentId) {
        this.target = target;
        this.groupId = groupId;
        this.contentId = contentId;
    }
}
