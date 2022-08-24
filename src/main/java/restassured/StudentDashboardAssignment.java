package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDashboardAssignment {
    @JsonProperty
    public Integer id;

    @JsonProperty
    public AssignmentContent content;

    @JsonProperty
    public String solution;

    @JsonProperty
    public Integer mark;
}
