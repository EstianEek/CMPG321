package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.example.LogicConfig;
@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "org.example.controller",
        "org.example.exception"
})
public class WebConfig {
}
