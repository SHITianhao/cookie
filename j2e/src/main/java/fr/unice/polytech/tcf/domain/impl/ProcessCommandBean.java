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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sth on 14/04/15.
 */
@Stateful
public class  ProcessCommandBean implements ProcessCommand {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    BoutiqueFinder boutiqueFinder;
    @EJB
    CookieFinder cookieFinder;
    @EJB
    IngredientFinder ingredientFinder;

    Commande commande;
    Cookie newCookie;
    List<Ingredient> newCookie_ings = new ArrayList<Ingredient>();
    List<Cookie> commande_cookies = new ArrayList<Cookie>();

    @Override
    public List<Boutique> listBoutiques() {
        return boutiqueFinder.findAll();
    }

    @Override
    public Commande createCommand(String owner, String boutique) {
        //clean les données
        newCookie = null;
        newCookie_ings.clear();
        commande_cookies.clear();
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
        Cookie cookie = cookieFinder.findByName(name);
        if (cookie != null){
            commande_cookies.add(cookie);
        }
    }

    //OPT . Créer un nouveau cookie
    @Override
    public void createNouveauCookie(String name) {
        newCookie = cookieFinder.findByName(name);
        newCookie_ings = new ArrayList<Ingredient>();
        if (newCookie == null){
            newCookie = new Cookie();
            newCookie.setName(name);
        }else {
            newCookie = null;
        }
    }

    @Override
    public List<Ingredient> findAllIngredients() {
        return ingredientFinder.findAll();
    }

    //3 . Ajouter des ingrédients
    @Override
    public void ajouterIngredient(String name) {
        Ingredient ingredient = ingredientFinder.findByName(name);
        if (newCookie != null && ingredient != null){
            newCookie_ings.add(ingredient);
        }
    }

    // 3b . en enlever
    @Override
    public void deleteIngredient(String name) {
        Ingredient ingredient = ingredientFinder.findByName(name);
        if (newCookie != null && ingredient != null){
//            newCookie
        }
    }

    @Override
    public void validNewCookie(){
        if (newCookie != null){
            entityManager.persist(newCookie);
            //bizzare...set should after persist,but don't need merge
            newCookie.setIngredients(newCookie_ings);
            commande_cookies.add(newCookie);
        }
        //clean list
        newCookie_ings = new ArrayList<Ingredient>();
        //clean new cookie
        newCookie = null;
    }

    @Override
    public String validate() {
        entityManager.persist(commande);
        //bizzare...set should after persist,but don't need merge
        commande.setCookies(commande_cookies);
        entityManager.merge(commande);
        String result = commande.generateCommand();
        return result;
    }
}
