package ua.pp.disik.json.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({})
public class Child extends Parent {
    private int tail = 8;
}
