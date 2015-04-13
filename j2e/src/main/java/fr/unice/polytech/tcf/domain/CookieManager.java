package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Cookie;

/**
 * Created by sth on 13/04/15.
 */
public interface CookieManager {
    public Cookie create(String name);
    public Cookie addIngredient(String cookie,String ingredient);
}
