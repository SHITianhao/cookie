package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.BoutiqueFinder;
import fr.unice.polytech.tcf.domain.IngredientFinder;
import fr.unice.polytech.tcf.domain.ProcessCommand;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Commande;
import fr.unice.polytech.tcf.entities.Cookie;
import fr.unice.polytech.tcf.entities.Ingredient;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 31/03/15.
 * Cette classe permet la création d'une commande a a z
 * Les étapes sont décrites
 */

@Stateless
public class ProcessCommandBean implements ProcessCommand {
    @EJB
    BoutiqueFinder finder;

    @EJB
    IngredientFinder imf;

    @PersistenceContext
    EntityManager entityManager;

    Commande c;
    Cookie k ;
    Set<Cookie> sc = new HashSet<Cookie>();
    Boutique b ;

    //0. Lister les boutiques
    @Override
    public List<Boutique> listBoutiques(){
        return finder.listBoutiques();
    }



    //1. Créer la commande en choissisant sa boutique
    @Override
    public void createCommand(String owner, String magasin){
        c = new Commande();
        c.setBoutique(magasin);
        k = new Cookie();
        c.setOwner(owner);
        b = finder.findByEndroit(magasin);
        c.addCookie(k);
        k.setCommande(c);
        sc.add(k);

    }

    //2. Lister les ingrédients pour que l'utilisateur puisse choisir
    @Override
    public List<Ingredient> findAllIngredients() {

        return imf.findAll();
    }

    //3 . Ajouter des ingrédients
    @Override
    public void ajouterIngredient(String name) {
        Ingredient i = imf.getIngredientByName(name);
        k.addIngredient(i);
        sc.add(k);
        i.setCookies(sc);
    }


    // 3b . en enlever
    @Override
    public void deleteIngredient(String name) {
        Ingredient i = imf.getIngredientByName(name);
        k.removeIngredient(i);
        sc.remove(k);
        i.setCookies(sc);
    }

    //OPT . Créer un nouveau cookie
    @Override
    public void ajouterCookie() {
        //entityManager.merge(k);
        k = new Cookie();
        c.addCookie(k);
        k.setCommande(c);
        sc.add(k);
    }

    @Override
    // 4 Valider la commande et tout rentrer dans la BDD
    public String validate()
    {
        c.calculatePrice();
		entityManager.persist(c);
        return c.generateCommand();
    }




}
