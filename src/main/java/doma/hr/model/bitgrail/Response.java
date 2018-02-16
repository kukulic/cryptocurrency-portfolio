package doma.hr.model.bitgrail;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import doma.hr.model.bitgrail.BTC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {

    @JsonProperty("BTC")
    private List<BTC> bTC = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BTC")
    public List<BTC> getBTC() {
        return bTC;
    }

    @JsonProperty("BTC")
    public void setBTC(List<BTC> bTC) {
        this.bTC = bTC;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
