package it.epicode.dao;

import it.epicode.gestione_eventi.entity.Location;


import jakarta.persistence.EntityManager;

import java.util.List;

public class LocationDAO {

    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
        ;
    }

    public void insertLocation(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    public Location locationById(Long id) {
        return em.find(Location.class, id);
    }

    public void updateLocation(Location location) {
        em.getTransaction().begin();
        em.merge(location);
        em.getTransaction().commit();
    }



    public void deleteLocation(Location location) {
        em.getTransaction().begin();
        em.remove(location);
        em.getTransaction().commit();
    }

    public void insertAll(List<Location> lista) {
        em.getTransaction().begin();
        for (Location e : lista) {
            em.persist(e);
        }
        em.getTransaction().commit();
    }


}
