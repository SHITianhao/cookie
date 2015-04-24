package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.CommandeFinder;
import fr.unice.polytech.tcf.entities.Commande;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by sth on 13/04/15.
 */
@Stateless
public class CommandeFinderBean implements CommandeFinder {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Commande findByOwner(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = builder.createQuery(Commande.class);
        Root<Commande> from = criteria.from(Commande.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("owner"), name));
        TypedQuery<Commande> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Commande findById(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = builder.createQuery(Commande.class);
        Root<Commande> from = criteria.from(Commande.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("id"), id));
        TypedQuery<Commande> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
