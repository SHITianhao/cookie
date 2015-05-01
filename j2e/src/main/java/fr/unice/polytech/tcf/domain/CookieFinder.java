package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Cookie;

import java.util.List;

/**
 * Created by sth on 13/04/15.
 */
public interface CookieFinder {
    public Cookie findByName(String name);

    public List<Cookie> findAll();
}
