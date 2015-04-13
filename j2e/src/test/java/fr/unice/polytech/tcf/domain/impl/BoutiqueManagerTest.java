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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by sth on 3/24/15.
 */
@RunWith(Arquillian.class)
public class BoutiqueManagerTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Boutique.class.getPackage())
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(BoutiqueManager.class.getPackage())
                .addPackage(BoutiqueManagerBean.class.getPackage());
    }

    @EJB
    private BoutiqueManager manager;

    @EJB
    private BoutiqueFinder finder;
    @EJB
    CommandeManager commandeManager;
    @EJB
    CookieManager cookieManager;
    @EJB
    IngredientManager ingredientManager;

    @PersistenceContext
    EntityManager entityManager;

    Calendar c1;
    Calendar c2;
    Boutique boutique;
    @Before
    public void init(){
        c1 = Calendar.getInstance();
        c2 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY,7);
        c2.set(Calendar.HOUR_OF_DAY,16);
        boutique = manager.create("Polytech", c1, c2, 0.19);
    }

    @Test
    public void testCreation()  {
        Boutique boutique2 = manager.create("Polytechnique", c1, c2, 0.19);
        assertEquals(boutique.getEndroit(), "Polytech");
        Boutique found = finder.findByEndroit("Polytech");
        Boutique found2 = finder.findByEndroit("Polytech");
        assertEquals(finder.listBoutiques().size(), 2);
        assertEquals(found.getId(), found2.getId());
        assertNotEquals(boutique.getEndroit(), boutique2.getEndroit());
        assertEquals(boutique.getHoraireClose(), found.getHoraireClose());
    }

    @Test
    public void testAddCommande(){
        Commande commande = commandeManager.create("boutique_test_1",0.19);
        Cookie cookie = cookieManager.create("boutique_test_1_k");
        Ingredient ingredient = ingredientManager.create("boutique_test_1_ing",10);
        cookie = cookieManager.addIngredient(cookie.getName(),ingredient.getName());
        commande = commandeManager.addCookie(commande.getId(),cookie.getName());
        boutique.addCommande(commande);

        Boutique found = finder.findByEndroit(boutique.getEndroit());
        assertEquals(found.nbCommande(),1);
    }
}
