package ua.pp.disik.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ua.pp.disik.json.converter.Converter;
import ua.pp.disik.json.entity.*;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
public class Application {
    private Converter converter;

    @SneakyThrows
    public Application() {
        this.converter = (Converter) Class.forName(
                System.getProperty("converter", "ua.pp.disik.json.converter.JacksonConverter")
        ).getConstructor().newInstance();
    }

    public void showBigDecimal() {
        BigDecimal number = converter.convertToObject(
                "entity/big-decimal-example.json",
                BigDecimalExample.class
        ).getNumber();
        Integer precision = number.precision();
        Integer scale = number.scale();
        log.debug("number {}", number);
        log.debug("precision {}", precision);
        log.debug("scale {}", scale);
    }

    public void showJson() {
        DoubleExample example = new DoubleExample();
        example.setNumber(10D / 3);
        String json = converter.convertToJson(example);
        log.debug("DoubleExample {}", json);
    }

    public void showDouble() {
        Double number = converter.convertToObject(
                "entity/double-example.json",
                DoubleExample.class
        ).getNumber();
        log.debug("Double {}", number / 2);
    }

    public void showTransitiveJson() {
        BigDecimalExample example = converter.convertToObject(
                "entity/big-decimal-example.json",
                BigDecimalExample.class
        );
        log.debug("number {}", example.getNumber());
        log.debug("BigDecimalExample {}", converter.convertToJson(example));
    }

    public void showMap() {
        MapExample mapExample = new MapExample();
        Map<String, String> map = new LinkedTreeMap<>();
        map.put("a", null);
        mapExample.setMap(map);
        log.debug("MapExample {}", converter.convertToJson(mapExample));
    }

    public void showException() {
        ChildException exception = new ChildException();
        exception.setDescription("not auth, not auth");
        log.debug("{}", converter.convertToJson(exception));
    }

    public void showObjectToTreeAndGetting() {
        Gson gson = new GsonBuilder().create();
        Collection<ListItem> collection = new ArrayList<>();
        collection.add(new ListItem("a"));
        collection.add(new ListItem("b"));
        log.debug("{}", gson.toJsonTree(collection).getAsJsonArray().get(0).getAsJsonObject().get("field").getAsString());
    }

    public void showFieldToMapKey() {
        log.debug("{}", converter.convertToObject("entity/maps.json", Maps.class));
    }

    public void showKeyOverlaying() {
        log.debug("{}", converter.convertToObject("entity/key-value.json", KeyValue.class));
    }

    public void showWithNested() {
        log.debug("{}", converter.convertToObject("entity/with-nested.json", WithNested.class));
    }

    public void showDefaultPrimitive() {
        log.debug("{}", converter.convertToObject("entity/primitive.json", Primitive.class));
    }

    @SneakyThrows
    public static void main(String[] args) {
        (new Application()).showWithNested();
    }
}
