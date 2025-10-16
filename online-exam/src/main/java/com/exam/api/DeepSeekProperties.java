package com.exam.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "deepseek")
@Data
public class DeepSeekProperties {
    private String apiKey;
    private String baseUrl;
}
