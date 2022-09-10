package com.example.springbootdocker2.controller;

import com.example.springbootdocker2.pokecards.PokemonCard;
import com.example.springbootdocker2.pokecards.PokemonCardDeck;
import com.example.springbootdocker2.repository.PokemonCardDeckRepository;
import com.example.springbootdocker2.repository.PokemonCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin()
public class PokemonCardController {

    @Autowired
    private PokemonCardRepository pokemonCardRepository;



    @GetMapping("/Pokemon")
    public List<PokemonCard> fetchPokemonCards(){
        return pokemonCardRepository.findAll();
    }




}
