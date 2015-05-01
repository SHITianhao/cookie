package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.BoutiqueFinder;
import fr.unice.polytech.tcf.entities.Boutique;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by sth on 3/24/15.
 */
@Stateless
@Remote
public class BoutiqueFinderBean implements BoutiqueFinder {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Boutique> findByHoraire(Date h) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boutique> criteria = builder.createQuery(Boutique.class);
        Root<Boutique> from = criteria.from(Boutique.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("horaire"), h));
        TypedQuery<Boutique> query = entityManager.createQuery(criteria.select(criteria
                .from(Boutique.class)));
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boutique findByEndroit(String endroit) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boutique> criteria = builder.createQuery(Boutique.class);
        Root<Boutique> from = criteria.from(Boutique.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("endroit"), endroit));
        TypedQuery<Boutique> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Boutique> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Boutique> cq = cb.createQuery(Boutique.class);
        TypedQuery<Boutique> allQuery = entityManager.createQuery(cq.select(cq.from(Boutique.class)));
        return allQuery.getResultList();
    }
}
