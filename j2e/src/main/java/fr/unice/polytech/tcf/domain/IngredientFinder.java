package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Ingredient;

import java.util.List;

/**
 * Created by sth on 10/04/15.
 */
public interface IngredientFinder {
    Ingredient getIngredientByName(String name);
    public List<Ingredient> findAll();
}
