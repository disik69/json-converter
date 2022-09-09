package ua.pp.disik.json.entity;

import lombok.Data;

import java.util.List;

@Data
public class KeyValue {
    @Data
    public static class Result<K, V> {
        private K key;
        private V value;
        private Integer a;
    }
    private List<Result<String, Integer>> result;
}
