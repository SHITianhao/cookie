package fr.unice.polytech.tcf.webservice.impl;

import fr.unice.polytech.tcf.domain.*;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Ingredient;
import fr.unice.polytech.tcf.webservice.ProcessCommandService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 31/03/15.
 */
@WebService(targetNamespace = "http://www.polytech.unice.fr/tcf")
@Stateless
public class ProcessCommandServiceImpl implements ProcessCommandService {

    @EJB
    BoutiqueFinder boutiqueFinder;
    @EJB
    IngredientManager addIngredient;
    @EJB
    IngredientFinder ingredientFinder;
    @EJB
    ProcessCommand processCommand;
    @EJB
    ViewStatistiques viewStatistiques;

    @Override
    public List<String> listIngredientsDetail() {
        List<String> result = new ArrayList<String>();
        for (Ingredient ingredient : processCommand.findAllIngredients()){
            result.add("name: "+ingredient.getName()+" prix: $"+ingredient.getPrice());
        }
        return result;
    }


    @Override
    public void addIngredientToCookie(String name) {
        processCommand.ajouterIngredient(name);
    }



    @Override
    public String getBoutique(String adresse) {
        return null;
    }


    @Override
    public List<String> listBoutiques() {
        List<Boutique> boutiques = processCommand.listBoutiques();
        List<String> results = new ArrayList<String>();
        for (Boutique b : boutiques){
            results.add(b.getEndroit());
        }
        return results;
    }

    @Override
    public void createCommand(String owner, String magasin) {
        processCommand.createCommand(owner,magasin);
    }

    @Override
    public String validCommande() {
       return processCommand.validate();
    }

    @Override
    public int viewStatistiqueCommande(String adress) {
        return viewStatistiques.getNbCommandes(adress);
    }

//    @Override
//    public int viewStatistiqueCookies(String adress) {
//        return viewStatistiques.getNbCookies(adress);
//    }

}
