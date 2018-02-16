package doma.hr.model;

import java.math.BigDecimal;
import java.util.List;

public class Coin {

    private String name;
    private BigDecimal coinValueBTC;
    private BigDecimal coinValueUSD;
    private List<BigDecimal> coinValueBTCList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCoinValueBTC() {
        return coinValueBTC;
    }

    public void setCoinValueBTC(BigDecimal coinValueBTC) {
        this.coinValueBTC = coinValueBTC;
    }

    public BigDecimal getCoinValueUSD() {
        return coinValueUSD;
    }

    public void setCoinValueUSD(BigDecimal coinValueUSD) {
        this.coinValueUSD = coinValueUSD;
    }

    public List<BigDecimal> getCoinValueBTCList() {
        return coinValueBTCList;
    }

    public void setCoinValueBTCList(List<BigDecimal> coinValueBTCList) {
        this.coinValueBTCList = coinValueBTCList;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "name='" + name + '\'' +
                ", coinValueBTC=" + coinValueBTC +
                ", coinValueUSD=" + coinValueUSD +
                ", coinValueBTCList=" + coinValueBTCList +
                '}';
    }
}
