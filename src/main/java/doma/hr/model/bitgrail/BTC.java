package doma.hr.model.bitgrail;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "market",
        "last",
        "high",
        "low",
        "volume",
        "coinVolume",
        "bid",
        "ask"
})
public class BTC {

    @JsonProperty("market")
    private String market;
    @JsonProperty("last")
    private String last;
    @JsonProperty("high")
    private String high;
    @JsonProperty("low")
    private String low;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("coinVolume")
    private String coinVolume;
    @JsonProperty("bid")
    private String bid;
    @JsonProperty("ask")
    private String ask;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("market")
    public String getMarket() {
        return market;
    }

    @JsonProperty("market")
    public void setMarket(String market) {
        this.market = market;
    }

    @JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }

    @JsonProperty("high")
    public String getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(String high) {
        this.high = high;
    }

    @JsonProperty("low")
    public String getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(String low) {
        this.low = low;
    }

    @JsonProperty("volume")
    public String getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @JsonProperty("coinVolume")
    public String getCoinVolume() {
        return coinVolume;
    }

    @JsonProperty("coinVolume")
    public void setCoinVolume(String coinVolume) {
        this.coinVolume = coinVolume;
    }

    @JsonProperty("bid")
    public String getBid() {
        return bid;
    }

    @JsonProperty("bid")
    public void setBid(String bid) {
        this.bid = bid;
    }

    @JsonProperty("ask")
    public String getAsk() {
        return ask;
    }

    @JsonProperty("ask")
    public void setAsk(String ask) {
        this.ask = ask;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "BTC{" +
                "market='" + market + '\'' +
                ", last='" + last + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", volume='" + volume + '\'' +
                ", coinVolume='" + coinVolume + '\'' +
                ", bid='" + bid + '\'' +
                ", ask='" + ask + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}