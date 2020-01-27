package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CsvImportController {

    @Autowired
    private CsvImportService importService;

    @PostMapping("/test")
    public List<CsvDataModel> loadUserModels(){
        return importService.loadUserModels();
    }
}
