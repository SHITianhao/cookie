package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.*;
import fr.unice.polytech.tcf.entities.Boutique;
import fr.unice.polytech.tcf.entities.Commande;
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

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by sth on 13/04/15.
 */
@RunWith(Arquillian.class)
public class CommandeManagerTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Commande.class.getPackage())
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(CommandeManager.class.getPackage())
                .addPackage(CommandeManagerBean.class.getPackage());
    }

    @EJB
    CommandeManager commandeManager;
    @EJB
    CommandeFinder commandeFinder;
    @EJB
    CookieManager cookieManager;
    @EJB
    IngredientManager ingredientManager;
    @EJB
    CreateBoutique createBoutique;
    @EJB
    BoutiqueFinder boutiqueFinder;

    Boutique boutique;
    Calendar c1;
    Calendar c2;

    @Before
    public void init(){
        c1 = Calendar.getInstance();
        c2 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY,7);
        c2.set(Calendar.HOUR_OF_DAY,16);
        boutique = createBoutique.create("commande_boutique", c1, c2, 0.19);
    }

    @Test
    public void testCreation(){
        Commande commande = commandeManager.create(boutique.getEndroit(),"sth",0.19);
        Commande commande1 = commandeManager.create(boutique.getEndroit(),"user",0.19);
        Commande found = commandeFinder.findByOwner("sth");
        Commande found2 = commandeFinder.findByOwner("user");
        assertEquals(commande.getId(), found.getId());
        assertNotEquals(commande.getId(), found2.getId());
        assertEquals(commande.getTaxe(),commande1.getTaxe(),0.000001);
    }

    @Test
    public void testAddCookie(){
        Commande commande = commandeManager.create(boutique.getEndroit(),"Cmd_test_1",0.19);
        Cookie cookie = cookieManager.create("Cmd_test_1_k");
        Ingredient ingredient = ingredientManager.create("Cmd_test_1_ing",10);
        cookie = cookieManager.addIngredient(cookie.getName(),ingredient.getName());
        commande = commandeManager.addCookie(commande.getId(),cookie.getName());
        Commande found = commandeFinder.findById(commande.getId());
        Commande found2 = commandeFinder.findByOwner(commande.getOwner());
        assertEquals(found.getCookies().size(),1);
        assertEquals(found.getOwner(),commande.getOwner());
        assertEquals(found2.getId(),commande.getId());
        found.calculatePrice();
        assertEquals(found.getPrixHT(),10,0.0000000001);
    }

}
