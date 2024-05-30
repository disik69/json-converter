package ua.pp.disik.json.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserPhone {
	private String phone;
	private List<String> messengerTypes;
	private Boolean verified;
}
