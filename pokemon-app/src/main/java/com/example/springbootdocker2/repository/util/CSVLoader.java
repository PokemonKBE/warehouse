package com.example.springbootdocker2.repository.util;

import com.example.springbootdocker2.pokecards.PokemonCard;
import com.example.springbootdocker2.repository.CardRepository;
import com.example.springbootdocker2.repository.DeckRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class CSVLoader {

    final static String POKEMONCARD_CSV = "csv/PokemonCards.csv";
    final static String POKEMONDECK_CSV = "csv/PokemonDeck.csv";
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
