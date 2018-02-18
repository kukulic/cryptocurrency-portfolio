package doma.hr.controller;

import doma.hr.model.bitgrail.BTC;
import doma.hr.model.bitgrail.BitGrailResponse;
import doma.hr.model.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController("/bitGrail")
public class BitGrailController {

    private static final Logger log = LoggerFactory.getLogger(BitGrailController.class);

    RestTemplate restTemplate = new RestTemplate();

    @Value("${bitGrailURL}")
    private String serviceURL;

    public List<Coin> addCoinsToListBitGrail(List<Coin> coinList) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        try {
            ResponseEntity<BitGrailResponse> bitGrailResponse = restTemplate.exchange("https://bitgrail.com/api/v1/markets", HttpMethod.GET, entity, BitGrailResponse.class);
            Iterator it = bitGrailResponse.getBody().getResponse().getBTC().iterator();

            while (it.hasNext()) {
                BTC obj = (BTC) it.next();
                if (obj.getMarket().equals("XRB/BTC")) {
                    for (Coin coinFromList : coinList) {
                        int itemIndex = coinList.indexOf(coinFromList);
                        if (coinFromList.getName().equals("XRB")) {
                            List<BigDecimal> valuesBTC = new ArrayList<>();
                            if (coinFromList.getCoinValueBTCList() != null)
                                valuesBTC = coinFromList.getCoinValueBTCList();
                            valuesBTC.add(new BigDecimal(obj.getLast()));
                            coinFromList.setCoinValueBTCList(valuesBTC);
                            coinList.set(itemIndex, coinFromList);
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            log.info("BitGrail not available at the momment {}", e);
            for (Coin coinFromList : coinList) {
                int itemIndex = coinList.indexOf(coinFromList);
                if (coinFromList.getName().equals("XRB")) {
                    List<BigDecimal> valuesBTC = new ArrayList<>();
                    if (coinFromList.getCoinValueBTCList() != null)
                        valuesBTC = coinFromList.getCoinValueBTCList();
                    valuesBTC.add(new BigDecimal(0.001).setScale(8, RoundingMode.CEILING));
                    coinFromList.setCoinValueBTCList(valuesBTC);
                    coinList.set(itemIndex, coinFromList);
                }
            }

        }

        return coinList;
    }
}
