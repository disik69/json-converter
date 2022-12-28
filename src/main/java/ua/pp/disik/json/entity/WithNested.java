package ua.pp.disik.json.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;

@Data
public class WithNested {
//    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
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
        private String type;
    }
    @Data
    public static class NestedC extends Nested {
        private Integer c = 1;
    }
    @Data
    public static class NestedD extends Nested {
        private Integer d = 1;
    }
    public static class NestedDeserializer extends JsonDeserializer<Nested> {
        @Override
        public Nested deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode value = p.readValueAsTree();
            JsonNode type = value.get("type");
            if (type != null && type.isTextual()) {
                if (type.asText().equals("c")) {
                    return p.getCodec().treeToValue(value, NestedC.class);
                } else if (type.asText().equals("d")) {
                    return p.getCodec().treeToValue(value, NestedD.class);
                }
            }
            return p.getCodec().treeToValue(value, Nested.class);
        }
    }
    @JsonDeserialize(using = NestedDeserializer.class)
    private Nested nested;
}
