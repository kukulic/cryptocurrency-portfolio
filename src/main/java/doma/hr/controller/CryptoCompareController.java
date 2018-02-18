package doma.hr.controller;

import doma.hr.model.Coin;
import doma.hr.model.cryptocompare.CryptoCompareResponse;
import doma.hr.model.cryptocompare.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller("cryptoCompareController")
public class CryptoCompareController {

    RestTemplate restTemplate = new RestTemplate();

    public List<Coin> addCoinsToListCryptoCompare(List<Coin> coinList) {

        CryptoCompareResponse cryptoCompareResponse = restTemplate.getForObject(
                "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BNB,NEO,ETH,BTC,ADA,GAS,XRP,QSP,GNT,TRX,BCH,ICX,SUB,NANO&tsyms=BTC,USD", CryptoCompareResponse.class);

        for (Map.Entry<String, Value> entry : cryptoCompareResponse.getCoinList().entrySet()) {
            Coin coin = new Coin();
            coin.setName(entry.getKey());
            for (Coin coinFromList : coinList) {
                int itemIndex = coinList.indexOf(coinFromList);
                if (coinFromList.getName().equals(entry.getKey())) {
                    List<BigDecimal> valuesBTC = new ArrayList<>();
                    if (coinFromList.getCoinValueBTCList() != null)
                        valuesBTC = coinFromList.getCoinValueBTCList();
                    valuesBTC.add(entry.getValue().getBtc());
                    coinFromList.setCoinValueBTCList(valuesBTC);
                    if (entry.getKey().equals("BTC"))
                        coinFromList.setCoinValueUSD(entry.getValue().getUsd());
                    coinList.set(itemIndex, coinFromList);
                }
            }
        }

        return coinList;
    }
}



