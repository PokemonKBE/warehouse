package com.example.springbootdocker2.repository.util;

import com.example.springbootdocker2.pokecards.PokemonCard;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


@Slf4j
@Component
public class PokemonCardCsvImporter {

    public List<PokemonCard> getPokemonCardDataFromCSV(String fileName){
        try {
            final MappingIterator<PokemonCard> mappingIterator = new CsvMapper().enable(CsvParser.Feature.WRAP_AS_ARRAY)
                    .readerWithSchemaFor(PokemonCard.class)
                    .readValues(new File(fileName));
            return mappingIterator.readAll();
        }catch (IOException e){
            e.printStackTrace();
            log.error("failed loading csv file in " + this.getClass());
            return Collections.emptyList();
        }
    }

}
