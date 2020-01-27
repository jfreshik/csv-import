package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class CsvImportService {

    final static private String filePath = "test.csv";

    public List<CsvDataModel> loadUserModels() {
       return loadUserModelFromResource(filePath, true);
    }

    public List<CsvDataModel> loadUserModelFromResource(String resourcePath, boolean skipHeader){
        try {
            File file = new ClassPathResource(resourcePath).getFile();
            return CsvLoader.loadObjectList(CsvDataModel.class, file, skipHeader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
