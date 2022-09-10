package com.example.springbootdocker2.controller;

import com.example.springbootdocker2.pokecards.PokemonCard;
import com.example.springbootdocker2.repository.CardRepository;
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
    private CardRepository cardRepository;





    @GetMapping("/Pokemon")
    public List<PokemonCard> fetchPokemonCards(){
        return cardRepository.findAll();
    }




}
