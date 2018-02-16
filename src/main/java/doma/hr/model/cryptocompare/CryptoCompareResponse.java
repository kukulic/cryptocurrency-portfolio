package doma.hr.model.cryptocompare;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CryptoCompareResponse {

    @JsonIgnore
    private Map<String, Value> coinList = new HashMap<String, Value>();

    @JsonAnyGetter
    public Map<String, Value> getCoinList() {
        return this.coinList;
    }

    @JsonAnySetter
    public void setCoinList(String name, Value value) {
        this.coinList.put(name, value);
    }

    @Override
    public String toString() {
        return "CryptoCompareResponse{" +
                "coinList=" + coinList +
                '}';
    }
}