package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    @JsonProperty("confirmed")
    public String confirmed;

    @JsonProperty("recovered")
    public String recovered;

    @JsonProperty("critical")
    public String critical;

    @JsonProperty("deaths")
    public String deaths;
}
