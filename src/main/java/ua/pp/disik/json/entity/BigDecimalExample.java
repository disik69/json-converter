package ua.pp.disik.json.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class BigDecimalExample {
    @SerializedName("gsonNumber")
    private BigDecimal number;

    @JsonGetter("jacksonWroteNumber")
    public BigDecimal getNumber() {
        return number;
    }

    @JsonSetter("jacksonNumber")
    public void setNumber(BigDecimal number) {
        this.number = number;
    }
}
