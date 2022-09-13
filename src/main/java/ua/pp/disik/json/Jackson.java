package ua.pp.disik.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ua.pp.disik.json.entity.*;

import java.io.FileReader;

@Slf4j
public class Jackson {
    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Cargo cargo = objectMapper.readValue(new FileReader("entity/cargo.json"), Cargo.class);

        String json = objectMapper.writeValueAsString(cargo);

        return;
    }
}
