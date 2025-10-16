package com.exam.api;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Data
public class SystemPromptProvider {

    @Value("classpath:systemPrompt.txt")
    private Resource resource;

    private String prompt;

    @PostConstruct
    public void init() throws IOException {
        this.prompt = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
