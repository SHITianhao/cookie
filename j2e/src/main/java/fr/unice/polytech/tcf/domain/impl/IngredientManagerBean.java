package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.IngredientManager;
import fr.unice.polytech.tcf.domain.IngredientFinder;
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

    @Override
    public Ingredient addIngredient(String name, double price){

        Ingredient i = new Ingredient(name,price);
        entityManager.persist(i);
        return i;
    }

    @Override
    public Ingredient deleteIngredient(String name){
        Ingredient i = finder.getIngredientByName(name);
        entityManager.remove(i);
        return i;
    }

}
