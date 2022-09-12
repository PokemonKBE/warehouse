package com.example.springbootdocker2.pokecards;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class PokemonCardDeck {

    @Id
    @Column(nullable = false, unique = true)
    private int id;

    @Column
    private String name;

    @Column
    @ManyToMany
    @JoinTable
    private List<PokemonCard> pokemonCardList;
}

