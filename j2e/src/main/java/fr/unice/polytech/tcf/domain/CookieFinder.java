package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Cookie;

/**
 * Created by sth on 13/04/15.
 */
public interface CookieFinder {
    public Cookie findByName(String name);
}
