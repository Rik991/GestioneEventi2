package it.epicode.dao;

import it.epicode.gestione_eventi.entity.Concerto;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ConcertoDAO {
    private EntityManager em;

    public void save(Concerto concerto) {
        em.getTransaction().begin();
        em.persist(concerto);
        em.getTransaction().commit();
    }

    public Concerto findById(Long id) {
        return em.find(Concerto.class, id);
    }

    public List<Concerto> findAll() {
        return em.createNamedQuery("Trova_tutto_Concerto", Concerto.class).getResultList();
    }

    public void update(Concerto concerto) {
        em.getTransaction().begin();
        em.merge(concerto);
        em.getTransaction().commit();
    }

    public void delete(Concerto concerto) {
        em.getTransaction().begin();
        em.remove(concerto);
        em.getTransaction().commit();
    }


}