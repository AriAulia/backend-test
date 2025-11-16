package id.co.microservice.finance.finance_service.service;

import id.co.microservice.finance.finance_service.dto.FrankfurterResponseDto;

public interface CurrencyService {

    /**
     * Get latest currency rates based on the provided base currency.
     * @param base the base currency code
     * @return FrankfurterResponseDto
     */
    FrankfurterResponseDto getCurrencyLatestRates(String base);

    /**
     * Get historical currency rates.
     * @return FrankfurterResponseDto
     */
    FrankfurterResponseDto getCurrencyHistoricalRates();

    /**
     * Get supported currencies.
     * @return FrankfurterResponseDto
     */
    FrankfurterResponseDto getSupportedCurrencies();

}
