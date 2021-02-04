package ua.pp.disik.json.converter;

public interface Converter {
    <T> T convertToObject(String path, Class<T> clazz);
    <T> String convertToJson(T object);
}
