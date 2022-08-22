package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class GroupData {
    @JsonProperty
    public String name;

    @JsonProperty
    List<Integer> studentsID;

    public GroupData(String name, List<Integer> studentsID) {
        this.name = name;
        this.studentsID = studentsID;
    }

    public GroupData() {
    }

}
