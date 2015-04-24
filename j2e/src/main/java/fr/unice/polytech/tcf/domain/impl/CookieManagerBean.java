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
import java.util.ArrayList;
import java.util.List;

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
    public Cookie create(String name,List<String> ingredients) {
        Cookie cookie = finder.findByName(name);
        if (cookie == null){
            cookie = new Cookie();
            cookie.setName(name);
            List<Ingredient> cookie_ings = new ArrayList<Ingredient>();
            for (String ing : ingredients){
                Ingredient i = ingredientFinder.findByName(ing);
                cookie_ings.add(i);
            }
            entityManager.persist(cookie);
            cookie.setIngredients(cookie_ings);
            entityManager.merge(cookie);
        }
        return cookie;
    }

}
