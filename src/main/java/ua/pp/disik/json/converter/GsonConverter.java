package ua.pp.disik.json.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;

import java.io.FileReader;

public class GsonConverter implements Converter {
    private final Gson objectMapper;

    public GsonConverter() {
        objectMapper = new GsonBuilder().create();
    }

    @Override
    @SneakyThrows
    public <T> T convertToObject(String path, Class<T> clazz) {
        return objectMapper.fromJson(new FileReader(path), clazz);
    }

    @Override
    @SneakyThrows
    public <T> String convertToJson(T object) {
        return objectMapper.toJson(object);
    }
}
