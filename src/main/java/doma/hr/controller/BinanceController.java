package doma.hr.controller;

import doma.hr.model.binance.BinanceResponse;
import doma.hr.model.Coin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController("/binance")
public class BinanceController {
    RestTemplate restTemplate = new RestTemplate();

    public List<Coin> addCoinsToListBinance(List<Coin> coinList) {

        BinanceResponse[] binanceResponse = restTemplate.getForObject("https://api.binance.com/api/v1/ticker/allPrices", BinanceResponse[].class);
        for (BinanceResponse binance : binanceResponse) {
            for (Coin coinFromList : coinList) {
                int itemIndex = coinList.indexOf(coinFromList);
                if ((coinFromList.getName()+ "BTC").equals(binance.getSymbol())) {
                    List<BigDecimal> valuesBTC = new ArrayList<>();
                    if (coinFromList.getCoinValueBTCList() != null)
                        valuesBTC = coinFromList.getCoinValueBTCList();
                    valuesBTC.add(new BigDecimal(binance.getPrice()));
                    coinFromList.setCoinValueBTCList(valuesBTC);
                    coinList.set(itemIndex, coinFromList);
                }
            }
        }
        return coinList;
    }
}
