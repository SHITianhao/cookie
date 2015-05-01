package fr.unice.polytech.tcf.webservice.impl;

import fr.unice.polytech.tcf.domain.*;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Cookie;
import fr.unice.polytech.tcf.entities.Ingredient;
import fr.unice.polytech.tcf.webservice.ManageService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sth on 24/04/15.
 */
@WebService(targetNamespace = "http://www.polytech.unice.fr/tcf")
@Stateless
public class ManageServiceImpl implements ManageService{
    @EJB
    IngredientFinder ingredientFinder;
    @EJB
    IngredientManager ingredientManager;
    @EJB
    BoutiqueFinder boutiqueFinder;
    @EJB
    CreateBoutique createBoutique;
    @EJB
    CookieManager cookieManager;
    @EJB
    CookieFinder cookieFinder;

    @Override
    public boolean createBoutique(String adresse, Calendar ouvert,Calendar fermer,double taxe) {
        Boutique boutique = boutiqueFinder.findByEndroit(adresse);
        if (boutique != null){
            return false;
        }
        else {
            boutique = createBoutique.create(adresse,ouvert,fermer,taxe);
            if (boutique != null)
                return true;
            else
                return false;
        }
    }

    @Override
    public boolean boutiqueIsExist(String adresse) {
        Boutique boutique = boutiqueFinder.findByEndroit(adresse);
        if (boutique == null)
            return false;
        else
            return true;
    }

    @Override
    public List<String> listBoutiques(){
        List<String> results = new ArrayList<String>();
        for (Boutique b : boutiqueFinder.findAll()){
            if (b != null){
                results.add(b.getEndroit());
            }
        }
        return results;
    }

    @Override
    public List<String> listIngredients() {
        List<String> result = new ArrayList<String>();
        for (Ingredient ingredient : ingredientFinder.findAll()){
            result.add(ingredient.getName());
        }
        return result;
    }

    @Override
    public boolean creatIngredient(String name, double price){
        if (ingredientFinder.findByName(name) == null){
            if (ingredientManager.create(name,price)!= null)
                return true;
        }
        return false;
    }

    @Override
    public boolean supprimerIngredient(String name) {
        if (ingredientManager.delete(name) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean ingredientIsExist(String name){
        if(ingredientFinder.findByName(name) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean createCookie(String name, List<String> ingredients) {
        Cookie cookie = cookieManager.create(name, ingredients);
        if (cookie == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimerCookie(@WebParam(name = "name") String name) {
        if (cookieManager.delete(name) != null){
            return true;
        }
        return false;
    }

    @Override
    public List<String> listCookies(){
        List<String> results = new ArrayList<String>();
        for (Cookie c : cookieFinder.findAll()){
            results.add(c.getName());
        }
        return results;
    }
}
