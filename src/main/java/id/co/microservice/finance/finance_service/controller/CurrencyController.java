package id.co.microservice.finance.finance_service.controller;

import id.co.microservice.finance.finance_service.constant.FinanceServiceConstant;
import id.co.microservice.finance.finance_service.dto.FrankfurterResponseDto;
import id.co.microservice.finance.finance_service.exception.FinanceServiceException;
import id.co.microservice.finance.finance_service.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/finance")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping(value = "/data/{resourceType}")
    public ResponseEntity<FrankfurterResponseDto> getCurrency(@PathVariable("resourceType") String resourceType) {

        switch (resourceType.toLowerCase()) {
            case FinanceServiceConstant.LATEST_IDR_RATES:
                log.info("Fetching latest IDR to USD rates");
                FrankfurterResponseDto latestRates = this.currencyService.getCurrencyLatestRates("IDR");
                return new ResponseEntity<>(latestRates, HttpStatus.OK);
            case FinanceServiceConstant.HISTORICAL_IDR_USD:
                log.info("Fetching historical");
                FrankfurterResponseDto historicalRates = this.currencyService.getCurrencyHistoricalRates();
                return new ResponseEntity<>(historicalRates, HttpStatus.OK);
            case FinanceServiceConstant.SUPPORTED_CURRENCIES:
                log.info("Fetching currency list");
                FrankfurterResponseDto supportedCurrencies = this.currencyService.getSupportedCurrencies();
                return new ResponseEntity<>(supportedCurrencies, HttpStatus.OK);
            default:
                log.warn("Unknown resource type requested: {}", resourceType);
                throw new FinanceServiceException("Unknown resource type: " + resourceType, HttpStatus.BAD_REQUEST);
        }

    }

}
