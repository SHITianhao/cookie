package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Boutique;

import java.util.Date;
import java.util.List;

/**
 * Created by sth on 22/03/15.
 */
public interface BoutiqueFinder {
    public List<Boutique> findByHoraire(Date h);
    public Boutique findByEndroit(String endroit);

    List<Boutique> listBoutiques();
}
