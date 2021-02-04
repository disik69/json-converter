package ua.pp.disik.json.converter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileReader;

public class JacksonConverter implements Converter {
    private final ObjectMapper objectMapper;

    public JacksonConverter() {
        this.objectMapper = createObjectMapper();
    }

    public static ObjectMapper createObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    @SneakyThrows
    public <T> T convertToObject(String path, Class<T> clazz) {
        return objectMapper.readValue(new FileReader(path), clazz);
    }

    @Override
    @SneakyThrows
    public <T> String convertToJson(T object) {
        return objectMapper.writeValueAsString(object);
    }
}
