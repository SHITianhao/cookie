package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.BoutiqueFinder;
import fr.unice.polytech.tcf.domain.CommandeFinder;
import fr.unice.polytech.tcf.domain.CommandeManager;
import fr.unice.polytech.tcf.domain.CookieFinder;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Commande;
import fr.unice.polytech.tcf.entities.Cookie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sth on 13/04/15.
 */
@Stateless
public class CommandeManagerBean implements CommandeManager {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    CommandeFinder finder;
    @EJB
    BoutiqueFinder boutiqueFinder;
    @EJB
    CookieFinder cookieFinder;


    @Override
    public Commande create(String boutique,String owner,double taxe) {
        Commande commande = finder.findByOwner(owner);
        Boutique b = boutiqueFinder.findByEndroit(boutique);
        if (commande == null && b != null){
            commande = new Commande();
            commande.setOwner(owner);
            commande.setTaxe(taxe);
            commande.setBoutique(b);
            entityManager.persist(commande);
        }
        return commande;
    }

    @Override
    public Commande addCookie(Long id, String cookie) {
        Commande commande = finder.findById(id);
        Cookie c = cookieFinder.findByName(cookie);
        if (commande != null && c != null){
            commande.addCookie(c);
            entityManager.merge(commande);
        }
        return commande;
    }

}
