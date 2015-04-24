package fr.unice.polytech.tcf.domain;

import fr.unice.polytech.tcf.entities.Cookie;

import java.util.List;

/**
 * Created by sth on 13/04/15.
 */
public interface CookieManager {
    public Cookie create(String name,List<String> ingredients);
}
