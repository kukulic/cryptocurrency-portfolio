package doma.hr.util;

import doma.hr.model.Coin;
import doma.hr.model.Portfolio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoinListUtil {


    public List<Coin> addPortfolioCoins() {

        List<Coin> coinList = new ArrayList<>();

        for (Map.Entry<String, BigDecimal> entry : Portfolio.getPortfolio().entrySet()) {
            Coin coin = new Coin();
            coin.setName(entry.getKey());
            coinList.add(coin);
        }

        return coinList;
    }

    public List<Coin> calculateMedian(List<Coin> coinList) {
        BigDecimal btc = new BigDecimal(0);
        for (Coin coin : coinList) {
            if (coin.getName().equals("BTC"))
                btc = coin.getCoinValueUSD();
        }

        for (Coin coin : coinList) {
            if (coin.getCoinValueBTCList() != null) {
                BigDecimal median = new BigDecimal(0);
                int counter = 0;
                for (BigDecimal value : coin.getCoinValueBTCList()) {
                    counter = counter + 1;
                    median = median.add(value);
                }
                coin.setCoinValueBTC(median.divide(new BigDecimal(counter)));
                coin.setCoinValueUSD(coin.getCoinValueBTC().multiply(btc).setScale(2, RoundingMode.CEILING));
            }
        }

        return coinList;
    }
}
