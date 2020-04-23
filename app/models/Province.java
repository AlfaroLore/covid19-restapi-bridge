package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Province {
    @JsonProperty("province")
    public String province;

    @JsonProperty("confirmed")
    public int confirmed;

    @JsonProperty("recovered")
    public int recovered;

    @JsonProperty("deaths")
    public int deaths;

    @JsonProperty("active")
    public int active;
}
