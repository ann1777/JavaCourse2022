package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentGroupTask {
    @JsonProperty
    public Integer id;

    @JsonProperty("student_id")
    public Integer studentId;

    @JsonProperty("content_id")
    public Integer contentId;

    @JsonProperty
    public String solution;

    @JsonProperty
    public Integer mark;


    public AssignmentGroupTask(Integer id, Integer studentId, Integer contentId, String solution, Integer mark) {
        this.id = id;
        this.studentId = studentId;
        this.contentId = contentId;
        this.solution = solution;
        this.mark = mark;
    }

    public AssignmentGroupTask() {
    }
}
