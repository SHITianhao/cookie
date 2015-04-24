package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.BoutiqueFinder;
import fr.unice.polytech.tcf.domain.CookieFinder;
import fr.unice.polytech.tcf.domain.IngredientFinder;
import fr.unice.polytech.tcf.domain.ProcessCommand;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Commande;
import fr.unice.polytech.tcf.entities.Cookie;
import fr.unice.polytech.tcf.entities.Ingredient;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sth on 14/04/15.
 */
@Stateful
public class ProcessCommandBean implements ProcessCommand {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    BoutiqueFinder boutiqueFinder;
    @EJB
    CookieFinder cookieFinder;
    @EJB
    IngredientFinder ingredientFinder;

    Commande commande;

    @Override
    public List<Boutique> listBoutiques() {
        return boutiqueFinder.listBoutiques();
    }

    @Override
    public Commande createCommand(String owner, String boutique) {
        Boutique b = boutiqueFinder.findByEndroit(boutique);
        if (b != null){
            commande = new Commande();
            commande.setOwner(owner);
            commande.setTaxe(b.getTaxe());
            commande.setBoutique(b);
        }
        return commande;
    }

    @Override
    public void addCookieDansCmd(String name) {
        Cookie cookie = co
    }

    //OPT . Créer un nouveau cookie
    @Override
    public void createNouveauCookie(String name) {

    }

    @Override
    public List<Ingredient> findAllIngredients() {
        return ingredientFinder.findAll();
    }

    //3 . Ajouter des ingrédients
    @Override
    public void ajouterIngredient(String name, String cookie) {

    }

    // 3b . en enlever
    @Override
    public void deleteIngredient(String name, String cookie) {

    }



    @Override
    public String validate(Long id) {
        return null;
    }
}
