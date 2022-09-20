package com.example.springbootdocker2.pokecards;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "pokemon")
@JsonPropertyOrder({"id", "name", "description", "hp", "type", "stage", "expansion", "rarity", "number", "illustrator", "price"})
public class PokemonCard {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String name;

    @Column(length = 1000)
    private String description;

    @Column
    private String hp;

    @Column
    private String type;

    @Column
    private String stage;

    @Column
    private String expansion;

    @Column
    private String rarity;

    @Column
    private String number;

    @Column
    private String illustrator;

    @Column
    private BigDecimal price;
}
