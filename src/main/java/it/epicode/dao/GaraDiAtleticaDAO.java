package it.epicode.dao;

import it.epicode.gestione_eventi.entity.GaraDiAtletica;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GaraDiAtleticaDAO {
    private EntityManager em;

    public void save(GaraDiAtletica gara) {
        em.getTransaction().begin();
        em.persist(gara);
        em.getTransaction().commit();
    }

    public GaraDiAtletica findById(Long id) {
        return em.find(GaraDiAtletica.class, id);
    }

    public List<GaraDiAtletica> findAll() {
        return em.createNamedQuery("Trova_tutto_GaraDiAtletica", GaraDiAtletica.class).getResultList();
    }

    public void update(GaraDiAtletica gara) {
        em.getTransaction().begin();
        em.merge(gara);
        em.getTransaction().commit();
    }

    public void delete(GaraDiAtletica gara) {
        em.getTransaction().begin();
        em.remove(gara);
        em.getTransaction().commit();
    }


}