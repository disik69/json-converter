package ua.pp.disik.json.entity;

import lombok.Data;

import java.util.Map;

@Data
public class Maps {
    private Map<Boolean, Boolean> booleanMap;
    private Map<Integer, Integer> intMap;
    private Map<Float, Float> floatMap;
}
