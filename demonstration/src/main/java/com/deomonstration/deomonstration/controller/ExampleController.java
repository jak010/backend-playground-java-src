package com.deomonstration.deomonstration.controller;

import com.deomonstration.deomonstration.dto.SaveData;
import com.deomonstration.deomonstration.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ExampleController {

    final private ExampleService exampleService;

    @GetMapping("/index")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/search-key")
    public String getKey(
            @RequestParam("key") String key
    ) {
        System.out.println(key);
        return exampleService.getKey(key);
    }


    @PostMapping("/save-key")
    public String saveKey(
            @RequestBody SaveData saveData
    ) {
        exampleService.setKey(saveData.getKey(), saveData.getValue());
        return "complete";
    }

}
