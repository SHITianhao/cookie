package fr.unice.polytech.tcf.webservice;

import fr.unice.polytech.tcf.domain.*;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Ingredient;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by user on 31/03/15.
 */
@WebService(targetNamespace = "http://www.polytech.unice.fr/tcf")
@Stateless
public class TcfServiceImpl implements TcfService {

    @EJB
    BoutiqueManager boutiqueManager;
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



//    @Override
//    public boolean creatIngredient(String name, double price){
//        if (ingredientFinder.getIngredientByName(name) == null){
//            if (addIngredient.addIngredient(name,price)!= null)
//                return true;
//        }
//        return false;
//    }

    @Override
    public List<String> listIngredients() {
        List<String> result = new ArrayList<String>();
        for (Ingredient ingredient : processCommand.findAllIngredients()){
            result.add(ingredient.getName());
        }
        return result;
    }

    @Override
    public List<String> listIngredientsDetail() {
        List<String> result = new ArrayList<String>();
        for (Ingredient ingredient : processCommand.findAllIngredients()){
            result.add("name: "+ingredient.getName()+" prix: $"+ingredient.getPrice());
        }
        return result;
    }

//    @Override
//    public boolean ingredientIsExist(String name){
//        if(ingredientFinder.getIngredientByName(name) != null){
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public boolean supprimerIngredient(String name) {
//        if (addIngredient.deleteIngredient(name) != null){
//            return true;
//        }
//        return false;
//    }

    @Override
    public void addIngredientToCookie(String name) {
        processCommand.ajouterIngredient(name);
    }



    @Override
    public String getBoutique(String adresse) {
        return null;
    }

    @Override
    public boolean creerBoutique(String adresse, Calendar ouvert,Calendar fermer,double taxe) {
        Boutique boutique = boutiqueFinder.findByEndroit(adresse);
        if (boutique != null){
            return false;
        }
        else {
            boutique = boutiqueManager.create(adresse,ouvert,fermer,taxe);
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
