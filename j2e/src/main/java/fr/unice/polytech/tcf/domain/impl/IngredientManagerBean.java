package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.CookieFinder;
import fr.unice.polytech.tcf.domain.IngredientFinder;
import fr.unice.polytech.tcf.domain.IngredientManager;
import fr.unice.polytech.tcf.entities.Ingredient;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by user on 22/03/15.
 */

@Stateless
@Remote
public class IngredientManagerBean implements IngredientManager {
    @PersistenceContext
    EntityManager entityManager;
    @EJB
    IngredientFinder finder;
    @EJB
    CookieFinder cookieFinder;

    @Override
    public Ingredient create(String name, double price){
        Ingredient ingredient = finder.findByName(name);
        if (ingredient == null){
            ingredient = new Ingredient();
            ingredient.setName(name);
            ingredient.setPrice(price);
            entityManager.persist(ingredient);
        }

        return ingredient;
    }

    @Override
    public Ingredient delete(String name) {
        Ingredient ingredient = finder.findByName(name);
        entityManager.remove(entityManager.merge(ingredient));
        return ingredient;
    }

}
