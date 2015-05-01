package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.ViewStatistiques;
import fr.unice.polytech.tcf.entities.Commande;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sth on 06/04/15.
 */
@Stateless
public class ViewStatistiquesBean implements ViewStatistiques {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Commande> getCommandes(String adresse)
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Commande> criteria = builder.createQuery(Commande.class);
        Root<Commande> from = criteria.from(Commande.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("boutique"), adresse));
        TypedQuery<Commande> query = entityManager.createQuery(criteria.select(criteria
                .from(Commande.class)));
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int getNbCommandes(String adresse){
        return getCommandes(adresse).size();
    }

    @Override
    public int getNbCookies(String adresse) {
        int nbCookies = 0;
        List<Commande> cmd = getCommandes(adresse);
        for (Commande c : cmd) {
            nbCookies += c.getCookies().size();
        }
        return nbCookies;
    }
}
