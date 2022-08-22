package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentGroupTask {
    @JsonProperty
    public Integer id;

    @JsonProperty
    public Integer student_id;

    @JsonProperty
    public Integer content_id;

    @JsonProperty
    public String solution;

    @JsonProperty
    public Integer mark;


    public AssignmentGroupTask(Integer id, Integer student_id, Integer content_id, String solution, Integer mark) {
        this.id = id;
        this.student_id = student_id;
        this.content_id = content_id;
        this.solution = solution;
        this.mark = mark;
    }

    public AssignmentGroupTask() {
    }
}
