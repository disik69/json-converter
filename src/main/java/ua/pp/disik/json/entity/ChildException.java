package ua.pp.disik.json.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildException extends ParentException {
    private String description;

    public ChildException() {
        super(401, "not auth");
    }
}
