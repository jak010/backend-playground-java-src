package com.deomonstration.deomonstration.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExampleService {

    private Map<String, String> inMemoryRepo = new HashMap<>();


    public String getKey(String key) {
        return inMemoryRepo.get(key);
    }

    public void setKey(
            String key,
            String value
    ) {
        inMemoryRepo.put(key, value);
    }

}
