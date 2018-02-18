package doma.hr.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Portfolio {

    private final static Map<String, BigDecimal> portfolio = new HashMap<String, BigDecimal>(){{
        put("BTC", new BigDecimal(0.02145));
        put("NEO", new BigDecimal(33));
        put("GAS", new BigDecimal(2));
 //       put("ADA", new BigDecimal(0));
        put("ETH", new BigDecimal(0.1));
        put("XRP", new BigDecimal(0));
        put("NANO", new BigDecimal(116));
        put("BNB", new BigDecimal(37.5));
        put("GNT", new BigDecimal(220));
 //       put("QSP", new BigDecimal(0));
 //       put("TRX", new BigDecimal(0));
        put("BCH", new BigDecimal(0.01837));
        put("ICX", new BigDecimal(50));
        put("SUB", new BigDecimal(70));
        put("XLM", new BigDecimal(400));
        put("OMG", new BigDecimal(10));
    }};

    public static Map<String, BigDecimal> getPortfolio() {
        return portfolio;
    }
}
