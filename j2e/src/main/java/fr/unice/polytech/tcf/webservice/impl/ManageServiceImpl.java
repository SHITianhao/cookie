package fr.unice.polytech.tcf.webservice.impl;

import fr.unice.polytech.tcf.domain.BoutiqueFinder;
import fr.unice.polytech.tcf.domain.CreateBoutique;
import fr.unice.polytech.tcf.domain.IngredientFinder;
import fr.unice.polytech.tcf.domain.IngredientManager;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Ingredient;
import fr.unice.polytech.tcf.webservice.ManageService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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

    @Override
    public boolean creerBoutique(String adresse, Calendar ouvert,Calendar fermer,double taxe) {
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
    public boolean ingredientIsExist(String name){
        if(ingredientFinder.findByName(name) != null){
            return true;
        }
        return false;
    }
}
