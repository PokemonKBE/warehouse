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
@Table(name = "pokemondeck")
public class PokemonCardDeck {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column
    @OneToMany
//    @JoinTable
    private List<PokemonCard> pokemonCardList;
}

