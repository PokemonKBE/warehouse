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
public class PokemonDeck {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column
    @ManyToMany
    @JoinTable
    private List<PokemonCard> pokemonCardList;
}

