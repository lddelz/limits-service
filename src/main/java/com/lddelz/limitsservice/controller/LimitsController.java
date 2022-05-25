package com.lddelz.limitsservice.controller;

import com.lddelz.limitsservice.configuration.LimitsProperties;
import com.lddelz.limitsservice.domain.Limits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LimitsController {

    private final Logger logger = LoggerFactory.getLogger(LimitsController.class);

    private final LimitsProperties limitsProperties;

    public LimitsController(LimitsProperties limitsProperties) {
        this.limitsProperties = limitsProperties;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits() {

        logger.info("Current limits: min {}, max {}", limitsProperties.getMinimum(), limitsProperties.getMaximum());

        return new Limits(limitsProperties.getMinimum(), limitsProperties.getMaximum());
    }

}