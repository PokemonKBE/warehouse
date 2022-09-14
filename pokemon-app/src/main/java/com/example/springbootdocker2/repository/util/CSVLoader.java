package com.example.springbootdocker2.repository.util;



import com.example.springbootdocker2.pokecards.PokemonCard;
import com.example.springbootdocker2.repository.CardRepository;
import com.example.springbootdocker2.repository.DeckRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.List;
import java.util.Objects;

@Configuration
public class CSVLoader {

    final static String POKEMONCARD_CSV = "F:\\Webstorm\\kbe-project\\warehouse\\pokemon-app\\src\\main\\resources\\PokemonInfo.csv";
    final static String POKEMONDECK_CSV = "F:\\Webstorm\\kbe-project\\warehouse\\pokemon-app\\src\\main\\resources\\PokemonDeck.csv";
    private final PokemonCardCSVImporter pokemonCardCsvImporter = new PokemonCardCSVImporter();
    private final PokemonCardDeckCSVImporter pokemonCardDeckCsvImporter = new PokemonCardDeckCSVImporter();

    @Bean
    CommandLineRunner initializeDatabase(CardRepository pokemonCardRepository, DeckRepository deckRepository) {
        return args -> {
            List<PokemonCard> pokemonCardList = pokemonCardCsvImporter.getPokemonCardDataFromCSV(POKEMONCARD_CSV);
            pokemonCardRepository.saveAll(pokemonCardList);

            deckRepository.saveAll(pokemonCardDeckCsvImporter.importCardDeckFromCsv(POKEMONDECK_CSV,pokemonCardList));
        };
    }
}
