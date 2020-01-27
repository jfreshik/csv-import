package com.example.demo;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * IMPORT CSV
 *
 * https://github.com/FasterXML/jackson-dataformats-text/tree/master/csv
 *
 */

public class CsvLoader {

    public static <T> List<T> loadObjectList(Class<T> type, File file, boolean skipHeader){

        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(skipHeader);

        CsvMapper mapper = new CsvMapper();
        try {
            MappingIterator<T> it =
                    mapper.readerFor(type).with(bootstrapSchema).readValues(file);

            return it.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
