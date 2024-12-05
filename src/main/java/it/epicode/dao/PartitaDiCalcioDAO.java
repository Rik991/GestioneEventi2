package it.epicode.dao;

import it.epicode.gestione_eventi.entity.PartitaDiCalcio;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PartitaDiCalcioDAO {
    private EntityManager em;

    public void save(PartitaDiCalcio parita) {
        em.getTransaction().begin();
        em.persist(parita);
        em.getTransaction().commit();
    }

    public PartitaDiCalcio findById(Long id) {
        return em.find(PartitaDiCalcio.class, id);
    }

    public List<PartitaDiCalcio> findAll() {
        return em.createNamedQuery("Trova_tutto_PartitaDiCalcio", PartitaDiCalcio.class).getResultList();
    }

    public void update(PartitaDiCalcio parita) {
        em.getTransaction().begin();
        em.merge(parita);
        em.getTransaction().commit();
    }

    public void delete(PartitaDiCalcio parita) {
        em.getTransaction().begin();
        em.remove(parita);
        em.getTransaction().commit();
    }


}