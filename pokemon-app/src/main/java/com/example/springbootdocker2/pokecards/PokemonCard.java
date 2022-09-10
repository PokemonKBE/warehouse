package com.example.springbootdocker2.pokecards;



import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemon")

public class PokemonCard {
    @Id
    @Column(name = "id",nullable = false)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false,length = 1000)
    private String description;

    @Column(name = "hp",nullable = false)
    private long hp;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "stage",nullable = false)
    private String stage;

    @Column(name = "Expansion",nullable = false)
    private String Expansion;

    @Column(name = "Rarity",nullable = false)
    private String Rarity;

    @Column(name = "number",nullable = false)
    private String number;

    @Column(name = "Illustrator",nullable = false)
    private String Illustrator;

    @Column(name = "price",nullable = false)
    private double price;


}
