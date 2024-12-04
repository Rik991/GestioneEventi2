package it.epicode.gestione_eventi.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;



    @Enumerated(EnumType.STRING)
    private statoPartecipazione stato;

    @ManyToOne
    @JoinColumn(name= "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name= "persona_id")
    private Persona persona;

}
