package doma.hr.model.cryptocompare;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Value {

    @JsonProperty("BTC")
    private BigDecimal btc;
    @JsonProperty("USD")
    private BigDecimal usd;


    public BigDecimal getBtc() {
        return btc;
    }

    public void setBtc(BigDecimal btc) {
        this.btc = btc;
    }

    public BigDecimal getUsd() {
        return usd;
    }

    public void setUsd(BigDecimal usd) {
        this.usd = usd;
    }


    @Override
    public String toString() {
        return "Value{" +
                "BTC = " + btc +
                ", USD = " + usd +
                '}';
    }
}
