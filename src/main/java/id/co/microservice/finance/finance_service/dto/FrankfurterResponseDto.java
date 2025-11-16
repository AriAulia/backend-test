package id.co.microservice.finance.finance_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FrankfurterResponseDto {

    private Double amount;
    private String base;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String date;
    private HashMap<String, Double> rates;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String startDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String endDate;

}
