package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Commande;

import java.util.List;

/**
 * Created by user on 07/04/15.
 */
public interface ViewStatistiques {

    int getNbCommandes(String adresse);

    int getNbCookies(String adresse);

    public List<Commande> getCommandes(String adresse);
}
