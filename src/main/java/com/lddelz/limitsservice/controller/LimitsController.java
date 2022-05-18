package com.lddelz.limitsservice.controller;

import com.lddelz.limitsservice.configuration.LimitsProperties;
import com.lddelz.limitsservice.domain.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final LimitsProperties limitsProperties;

    public LimitsController(LimitsProperties limitsProperties) {
        this.limitsProperties = limitsProperties;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(limitsProperties.getMinimum(), limitsProperties.getMaximum());
    }

}