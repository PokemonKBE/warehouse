package com.example.springbootdocker2.repository;

import com.example.springbootdocker2.pokecards.PokemonCardDeck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonCardDeckRepository extends JpaRepository<PokemonCardDeck,Long> {
}
