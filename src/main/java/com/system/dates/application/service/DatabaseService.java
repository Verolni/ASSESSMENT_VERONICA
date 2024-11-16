package com.system.dates.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    @Value("${spring.datasource.url}")
    private String databaseUrl;
}
