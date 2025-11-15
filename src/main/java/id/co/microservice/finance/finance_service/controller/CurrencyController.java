package id.co.microservice.finance.finance_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/finance")
public class CurrencyController {

    @GetMapping(value = "/data/{resourceType}")
    public String getCurrency(@PathVariable("resourceType") String resourceType) {
        log.info("Fetching currency data for resource type: {}", resourceType);
        return "Currency Data";
    }

}
