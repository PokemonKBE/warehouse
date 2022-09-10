package com.example.springbootdocker2.pokecards;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemondeck")
public class PokemonCardDeck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    @ManyToMany
    @JoinTable
    private List<PokemonCard> pokemonCardList;



}
