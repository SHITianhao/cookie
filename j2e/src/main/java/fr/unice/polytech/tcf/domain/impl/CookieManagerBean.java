package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.CookieFinder;
import fr.unice.polytech.tcf.domain.CookieManager;
import fr.unice.polytech.tcf.domain.IngredientFinder;
import fr.unice.polytech.tcf.entities.Cookie;
import fr.unice.polytech.tcf.entities.Ingredient;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sth on 13/04/15.
 */
@Stateless
public class CookieManagerBean implements CookieManager {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    CookieFinder finder;
    @EJB
    IngredientFinder ingredientFinder;

    @Override
    public Cookie create(String name) {
        Cookie cookie = finder.findByName(name);
        if (cookie == null){
            cookie = new Cookie();
            cookie.setName(name);
            entityManager.persist(cookie);
        }
        return cookie;
    }

    @Override
    public Cookie addIngredient(String cookie,String ingredient){
        Ingredient ing = ingredientFinder.findByName(ingredient);
        Cookie ck = finder.findByName(cookie);
        if (ck != null && ing != null){
            ck.addIngredient(ing);
            entityManager.merge(ck);
        }
        return ck;
    }
}
