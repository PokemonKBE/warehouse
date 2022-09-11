package com.example.springbootdocker2.pokecards;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

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
    @Column(name = "ID",nullable = false)
    private long id;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Description",nullable = false,length = 1000)
    private String description;

    @Column(name = "HP",nullable = false)
    private long hp;

    @Column(name = "Type",nullable = false)
    private String type;

    @Column(name = "Stage",nullable = false)
    private String stage;

    @Column(name = "Expansion",nullable = false)
    private String Expansion;

    @Column(name = "Rarity",nullable = false)
    private String Rarity;

    @Column(name = "Number",nullable = false)
    private String number;

    @Column(name = "Illustrator",nullable = false)
    private String Illustrator;

    @Column(name = "Price",nullable = false)
    private double price;


}
