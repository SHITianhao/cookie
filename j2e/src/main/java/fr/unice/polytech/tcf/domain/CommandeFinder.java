package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Commande;

/**
 * Created by sth on 13/04/15.
 */
public interface CommandeFinder {
    public Commande findByOwner(String name);
    public Commande findById(Long id);
}
