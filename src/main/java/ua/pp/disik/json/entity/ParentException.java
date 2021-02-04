package ua.pp.disik.json.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed"})
public class ParentException extends RuntimeException {
    private int code;

    public ParentException(int code, String message) {
        super(message);
        this.code = code;
    }
}
