package it.epicode.gestione_eventi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "concerti")
@NamedQuery(name = "Trova_Concerti_Streaming", query = "SELECT a FROM Concerto a WHERE a.inStreaming = :inStreaming")
public class Concerto extends Evento {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private genere genere;
    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;
}
