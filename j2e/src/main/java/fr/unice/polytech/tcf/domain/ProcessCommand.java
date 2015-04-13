package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Ingredient;

import java.util.List;

/**
 * Created by user on 05/04/15.
 */
public interface ProcessCommand {


    //0. Lister les boutiques
    List<Boutique> listBoutiques();

    //1. Créer la commande
    void createCommand(String owner, String magasin);

    //2. Lister les ingrédients pour que l'utilisateur puisse choisir
    List<Ingredient> findAllIngredients();

    //3 . Ajouter des ingrédients
    void ajouterIngredient(String name);

    // 3b . en enlever
    void deleteIngredient(String name);

    //OPT . Créer un nouveau cookie
    void ajouterCookie();

    // 4 Valider la commande
    public String validate();
}
