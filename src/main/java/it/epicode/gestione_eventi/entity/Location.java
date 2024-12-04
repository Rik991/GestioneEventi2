package it.epicode.gestione_eventi.entity;

import jakarta.persistence.*;
import lombok.*;




@Entity
@Data
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String citta;

}
