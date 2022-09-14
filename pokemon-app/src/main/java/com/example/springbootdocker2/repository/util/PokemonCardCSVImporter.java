package com.example.springbootdocker2.repository.util;

import com.example.springbootdocker2.pokecards.PokemonCard;
import com.example.springbootdocker2.pokecards.PokemonCardDeck;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


@Slf4j
@Component
public class PokemonCardCSVImporter {

    public List<PokemonCard> getPokemonCardDataFromCSV(String fileName){
        try {
            CsvMapper m = new CsvMapper().enable(CsvParser.Feature.WRAP_AS_ARRAY);
            CsvSchema schema = m.schemaFor(PokemonCard.class).withHeader();
            MappingIterator<PokemonCard> iterator = m.readerFor(PokemonCard.class).with(schema).readValues(new File(fileName));

            return iterator.readAll();
        }catch (IOException e){
            e.printStackTrace();
            log.error("failed loading csv file in " + this.getClass());
            return Collections.emptyList();
        }
    }

}
