package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Boutique;

import java.util.Calendar;

/**
 * Created by sth on 22/03/15.
 */
public interface BoutiqueManager {
    Boutique create(String endroit, Calendar open, Calendar close, double taxe);
}
