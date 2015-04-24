package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.CookieFinder;
import fr.unice.polytech.tcf.domain.CookieManager;
import fr.unice.polytech.tcf.domain.IngredientFinder;
import fr.unice.polytech.tcf.domain.IngredientManager;
import fr.unice.polytech.tcf.entities.Cookie;
import fr.unice.polytech.tcf.entities.Ingredient;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by sth on 13/04/15.
 */
@RunWith(Arquillian.class)
public class CookieManagerTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Cookie.class.getPackage())
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(CookieManager.class.getPackage())
                .addPackage(CookieManagerBean.class.getPackage());
    }

    @EJB
    CookieManager cookieManager;
    @EJB
    CookieFinder cookieFinder;
    @EJB
    IngredientManager ingredientManager;
    @EJB
    IngredientFinder ingredientFinder;

    List<String> ings = new ArrayList<String>();

    @Before
    public void init(){
        ings.add("cookie_ing_1");
        ings.add("cookie_ing_2");

        Ingredient i = ingredientManager.create("cookie_ing_1",100);
        Ingredient i1 = ingredientManager.create("cookie_ing_2",100);
    }


    @Test
    public void testCreation(){
        Cookie cookie = cookieManager.create("cookie_test1",ings);
        Cookie cookie1 = cookieManager.create("cookie_test2",ings);
        Cookie found = cookieFinder.findByName("cookie_test1");
        Cookie found1 = cookieFinder.findByName("cookie_test2");
        assertEquals(cookie.getId(),found.getId());
        assertNotEquals(cookie.getId(), found1.getId());
    }

    @Test
    public void testAddIngredient(){
        Cookie cookie = cookieManager.create("cookie_test3",ings);
        Cookie found = cookieFinder.findByName("cookie_test3");
        assertEquals(found.nbIngredient(),2);
    }
}
