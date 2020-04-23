package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Country {
    @JsonProperty("country")
    public String country;

    @JsonProperty("provinces")
    public List<Province> provinces;

    @JsonProperty("latitude")
    public double latitude;

    @JsonProperty("longitude")
    public double longitude;

    @JsonProperty("date")
    public String date;
}
