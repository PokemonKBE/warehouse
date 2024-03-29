package com.example.springbootdocker2.util;

import com.example.springbootdocker2.pokecards.PokemonCard;
import com.example.springbootdocker2.pokecards.PokemonDeck;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public class PokemonDeckCSVImporter {

    public List<PokemonDeck> importDeckFromCsv(String fileName, List<PokemonCard> pokemonCardList){
        List<PokemonDeck> res = importLinesFromCsv(fileName).stream()
                .map(elem -> createPokemonDeck(pokemonCardList,elem))
                .collect(Collectors.toList());

        return res;
    }

    private PokemonDeck createPokemonDeck(List<PokemonCard> pokemonCardList, List<String> elem) {
        var list = createPokemonCardList(pokemonCardList,elem.get(2));

        return new PokemonDeck()
                .setId(Integer.parseInt(elem.get(0)))
                .setName(elem.get(1))
                .setPokemonCardList(list);
    }

    private List<PokemonCard> createPokemonCardList(List<PokemonCard> pokemonCardList, String elem) {
        return Arrays.stream(elem.split("-"))
                .map(cards -> pokemonCardList.get(Integer.parseInt(cards)))
                .collect(Collectors.toList());
    }

    private List<List<String>> importLinesFromCsv(String fileName) {
        var records = new ArrayList<List<String>>();
        try {
            var br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("failed loading csv file in " + this.getClass());
            return Collections.emptyList();
        }

        return records;
    }
}
