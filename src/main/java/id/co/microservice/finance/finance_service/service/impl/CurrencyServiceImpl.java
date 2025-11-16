package id.co.microservice.finance.finance_service.service.impl;

import id.co.microservice.finance.finance_service.dto.FrankfurterResponseDto;
import id.co.microservice.finance.finance_service.feign.FrankfurterFeign;
import id.co.microservice.finance.finance_service.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final FrankfurterFeign frankfurterFeign;

    @Autowired
    public CurrencyServiceImpl(FrankfurterFeign frankfurterFeign) {
        this.frankfurterFeign = frankfurterFeign;
    }

    @Override
    public FrankfurterResponseDto getCurrencyLatestRates(String base) {
        log.info("Fetching latest currency rates for base: {}", base);
        return this.frankfurterFeign.getLatestRate(base);
    }

    @Override
    public FrankfurterResponseDto getCurrencyHistoricalRates() {
        log.info("Fetching historical currency rates");
        return this.frankfurterFeign.getHistoricalRate();
    }

    @Override
    public FrankfurterResponseDto getSupportedCurrencies() {
        log.info("Fetching supported currencies");
        return this.frankfurterFeign.getCurrencies();
    }
}
