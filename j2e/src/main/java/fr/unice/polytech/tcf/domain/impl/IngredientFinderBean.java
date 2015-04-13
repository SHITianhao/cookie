package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.IngredientFinder;
import fr.unice.polytech.tcf.entities.Ingredient;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sth on 10/04/15.
 */
@Stateless
@Remote
public class IngredientFinderBean implements IngredientFinder{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Ingredient getIngredientByName(String name)
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingredient> criteria = builder.createQuery(Ingredient.class);
        Root<Ingredient> from = criteria.from(Ingredient.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("name"), name));
        TypedQuery<Ingredient> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Ingredient> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingredient> cq = cb.createQuery(Ingredient.class);
        TypedQuery<Ingredient> allQuery = entityManager.createQuery(cq.select(cq.from(Ingredient.class)));
        return allQuery.getResultList();
    }
}
