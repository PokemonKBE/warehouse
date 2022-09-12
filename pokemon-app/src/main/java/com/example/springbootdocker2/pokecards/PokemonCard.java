package com.example.springbootdocker2.pokecards;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemon")
@JsonPropertyOrder({"ID","Name","Description","HP","Type","Stage","Expansion","Rarity","Number","Illustrator","Price"})
//ID,Name,Description,HP,Type,Stage,Expansion,Rarity,Number,Illustrator,Price
public class PokemonCard {
    @Id
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false,length = 1000)
    private String description;

    @Column(name = "hp",nullable = false)
    private int hp;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name = "stage",nullable = false)
    private String stage;

    @Column(name = "expansion",nullable = false)
    private String Expansion;

    @Column(name = "rarity",nullable = false)
    private String Rarity;

    @Column(name = "number",nullable = false)
    private String number;

    @Column(name = "illustrator",nullable = false)
    private String Illustrator;

    @Column(name = "price",nullable = false)
    private double price;


}

