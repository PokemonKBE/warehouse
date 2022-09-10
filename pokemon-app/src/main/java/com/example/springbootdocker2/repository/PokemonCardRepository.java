package com.example.springbootdocker2.repository;

import com.example.springbootdocker2.pokecards.PokemonCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonCardRepository extends JpaRepository<PokemonCard,Long> {

}
