package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class GroupData {
    @JsonProperty
    public String name;

    @JsonProperty
    List<Integer> students;

    public GroupData(String name, List<Integer> students) {
        this.name = name;
        this.students = students;
    }

    public GroupData(String groupTask) {
    }

    public String post(String groups) {
        return Arrays.deepToString(new Student[2][]);
    }


    public GroupData() {
    }

}
