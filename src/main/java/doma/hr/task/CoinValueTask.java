package doma.hr.task;

import doma.hr.model.Coin;
import doma.hr.service.CoinService;
import doma.hr.util.CoinListUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CoinValueTask {

    private static final Logger log = LoggerFactory.getLogger(CoinValueTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @PostConstruct
    public  void init() {
        getCoinValues();
    }

    @Scheduled(cron = "0 * * ? * *")
    public void getCoinValues() {
        List<Coin> coinList;
        CoinListUtil coinListUtil = new CoinListUtil();
        CoinService coinService = new CoinService();

        coinList = coinListUtil.addPortfolioCoins();
        System.out.println("----------------------------------------------------");
        System.out.println("The time is now: " + dateFormat.format(new Date()));
        coinService.getCoins(coinList);

    }
}
