package it.epicode.dao;


import it.epicode.gestione_eventi.entity.Persona;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PersonaDAO {


    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
        ;
    }

    public void insertPersona(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona personaById(Long id) {
        return em.find(Persona.class, id);
    }

    public void updatePersona(Persona persona) {
        em.getTransaction().begin();
        em.merge(persona);
        em.getTransaction().commit();
    }

    public void updatePersona(Long id, Persona persona) {
        Persona persReale = personaById(id);
        persReale.setNome(persReale.getNome());
        persReale.setCognome(persReale.getCognome());
        persReale.setEmail(persReale.getEmail());
        persReale.setDataNascita(persReale.getDataNascita());
        persReale.setSesso(persReale.getSesso());
        persReale.setListaPartecipazioni(persReale.getListaPartecipazioni());



        em.getTransaction().begin();
        em.merge(persReale);
        em.getTransaction().commit();
    }

    public void deletePersona(Long id) {
        Persona persReale = personaById(id);
        em.getTransaction().begin();
        em.remove(persReale);
        em.getTransaction().commit();
    }

    public void deletePersona(Persona persona) {
        em.getTransaction().begin();
        em.remove(persona);
        em.getTransaction().commit();
    }

    public void insertAll(List<Persona> lista) {
        em.getTransaction().begin();
        for (Persona e : lista) {
            em.persist(e);
        }
        em.getTransaction().commit();
    }
}
