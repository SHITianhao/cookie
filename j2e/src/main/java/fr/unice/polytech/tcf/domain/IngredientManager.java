package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Ingredient;

/**
 * Created by user on 22/03/15.
 */
public interface IngredientManager {
    public Ingredient create(String name, double price);
    public Ingredient remove(String name);
    public Ingredient addCookie(String name,String cookie);
}
