package it.epicode.gestione_eventi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "persone")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_nascita",nullable = false)
    private LocalDate dataNascita;

    @Enumerated(EnumType.STRING)
    private sesso sesso;

    //UNA PERSONA PUò ANDARE A PIù EVENTI (UNO A TANTI)
    @OneToMany(mappedBy = "persona") // IL MAPPED DOPO IL ....ToMany
    private List<Partecipazione> listaPartecipazioni = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "gara_di_atletica_id")
    private GaraDiAtletica garaDiAtletica;



}
