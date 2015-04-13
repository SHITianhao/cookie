package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.BoutiqueFinder;
import fr.unice.polytech.tcf.domain.BoutiqueManager;
import fr.unice.polytech.tcf.domain.CommandeFinder;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Commande;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;

/**
 * Created by sth on 3/24/15.
 */
@Stateless
@Remote
public class BoutiqueManagerBean implements BoutiqueManager {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    BoutiqueFinder finder;
    @EJB
    CommandeFinder commandeFinder;

    @Override
    public Boutique create(String endroit, Calendar open, Calendar close, double taxe) {
        Boutique boutique = finder.findByEndroit(endroit);
        if (boutique == null){
            boutique = new Boutique();
            boutique.setEndroit(endroit);
            boutique.setHoraireOpen(open);
            boutique.setHoraireClose(close);
            boutique.setTaxe(taxe);
            entityManager.persist(boutique);
        }
        return boutique;
    }

    @Override
    public Boutique addCommande(String adresse, Long id){
        Boutique boutique = finder.findByEndroit(adresse);
        Commande commande = commandeFinder.findById(id);
        if (boutique != null && commande != null){
            boutique.addCommande(commande);
            entityManager.merge(boutique);
        }
        return boutique;
    }



}
