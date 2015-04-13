package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Commande;

/**
 * Created by sth on 13/04/15.
 */
public interface CommandeManager {
    public Commande create(String owner,double taxe);
    public Commande addCookie(Long id,String cookie);
}
