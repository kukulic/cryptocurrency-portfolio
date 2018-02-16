package doma.hr.service;

import doma.hr.controller.BinanceController;
import doma.hr.controller.BitGrailController;
import doma.hr.controller.CryptoCompareController;
import doma.hr.model.Coin;
import doma.hr.model.Portfolio;
import doma.hr.util.CoinListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Service
public class CoinService {

 //   @Autowired
//    private CryptoCompareController cryptoCompareController;

    private BigDecimal sumUSD = new BigDecimal(0);
    private BigDecimal sumBTC = new BigDecimal(0);

    public List<Coin> getCoins(List<Coin> coinList) {
        CoinListUtil coinListUtilUtil = new CoinListUtil();
        CryptoCompareController cryptoCompareController = new CryptoCompareController();
        BinanceController binanceController = new BinanceController();
        BitGrailController bitGrailController = new BitGrailController();

        cryptoCompareController.addCoinsToListCryptoCompare(coinList);
        binanceController.addCoinsToListBinance(coinList);
        bitGrailController.addCoinsToListBitGrail(coinList);

        coinListUtilUtil.calculateMedian(coinList);

        for (Coin coin : coinList) {
            for (Map.Entry<String, BigDecimal> entry : Portfolio.getPortfolio().entrySet()) {
                if (entry.getKey().equals(coin.getName())) {
                    sumUSD = sumUSD.add(coin.getCoinValueUSD().multiply(entry.getValue()));
                    sumBTC = sumBTC.add(coin.getCoinValueBTC().multiply(entry.getValue()));
                    System.out.println(entry.getKey() + " - " + coin.getCoinValueUSD().multiply(entry.getValue()).setScale(2, RoundingMode.CEILING) + " USD / " + coin.getCoinValueBTC() + " BTC - " + coin.getCoinValueUSD() + " USD");
                }
            }
        }

        System.out.println("Suma USD: " + sumUSD.setScale(2, RoundingMode.CEILING));
        System.out.println("Suma BTC: " + sumBTC.setScale(5, RoundingMode.CEILING));

        return coinList;
    }
}
