package ua.pp.disik.json.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserEntity {
    private String name;
    private UserPhone phone;
}
