package com.example.springbootdocker2.repository.util;



import com.example.springbootdocker2.pokecards.PokemonCard;
import com.example.springbootdocker2.repository.CardRepository;
import com.example.springbootdocker2.repository.DeckRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CsvLoader {

    final static String POKEMONCARD_CSV = "C:\\Users\\Nasiem Ziad\\IdeaProjects\\warehouse\\pokemon-app\\src\\main\\resources\\PokemonInfo.csv";
    final static String POKEMONDECK_CSV ="C:\\Users\\Nasiem Ziad\\IdeaProjects\\warehouse\\pokemon-app\\src\\main\\resources\\PokemonDeck.csv";
    private final PokemonCardCsvImporter pokemonCardCsvImporter = new PokemonCardCsvImporter();
    private final PokemonCardDeckCsvImporter pokemonCardDeckCsvImporter = new PokemonCardDeckCsvImporter();

    @Bean
    CommandLineRunner initializeDatabase(CardRepository pokemonCardRepository, DeckRepository deckRepository) {
        return args -> {
            List<PokemonCard> pokemonCardList = pokemonCardCsvImporter.getPokemonCardDataFromCSV(POKEMONCARD_CSV);
           pokemonCardRepository.saveAll(pokemonCardList);

           deckRepository.saveAll(pokemonCardDeckCsvImporter.importCardDeckFromCsv(POKEMONDECK_CSV,pokemonCardList));
        };
    }
}
