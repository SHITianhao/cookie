package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.ProcessCommand;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Ingredient;

import java.util.List;

/**
 * Created by sth on 14/04/15.
 */
public class ProcessCommandBean implements ProcessCommand {
    @Override
    public List<Boutique> listBoutiques() {
        return null;
    }

    @Override
    public void createCommand(String owner, String magasin) {

    }

    @Override
    public List<Ingredient> findAllIngredients() {
        return null;
    }

    @Override
    public void ajouterIngredient(String name) {

    }

    @Override
    public void deleteIngredient(String name) {

    }

    @Override
    public void ajouterCookie() {

    }

    @Override
    public String validate() {
        return null;
    }
}
