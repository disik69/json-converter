package ua.pp.disik.json.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Data;

@Data
public class WithNested {
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public static WithNested getInstance(@JsonProperty("common") int common,
                                         @JacksonInject Nested nested) {
        WithNested instance = new WithNested();
        instance.nested = nested;

        return instance;
    }

    private int common;

    @Data
    public static class Nested {
        private Integer a = 1;
        private boolean b = true;
    }
    private Nested nested;
}
