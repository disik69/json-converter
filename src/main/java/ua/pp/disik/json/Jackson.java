package ua.pp.disik.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ua.pp.disik.json.entity.*;

import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class Jackson {
    public static class UserPhoneSerializer extends StdSerializer<UserPhone> {
        public UserPhoneSerializer(Class<UserPhone> t) {
            super(t);
        }

        @Override
        public void serialize(UserPhone value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeStartObject();
            gen.writeBooleanField("verified", value.getVerified());
            gen.writeEndObject();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UserEntity user1 = objectMapper.readValue(new FileReader("entity/user-entity.json"), UserEntity.class);
        String json1 = objectMapper.writeValueAsString(user1);
        log.debug(json1);

        SimpleModule userPhoneModule = new SimpleModule();
        userPhoneModule.addSerializer(UserPhone.class, new UserPhoneSerializer(UserPhone.class));
        objectMapper.registerModule(userPhoneModule);

        UserEntity user2 = objectMapper.readValue(new FileReader("entity/user-entity.json"), UserEntity.class);
        String json2 = objectMapper.writeValueAsString(user2);
        log.debug(json2);
    }
}
