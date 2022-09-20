package com.example.springbootdocker2.repository;

import com.example.springbootdocker2.pokecards.PokemonDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeckRepository extends JpaRepository<PokemonDeck,Integer> {
}
