package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.IngredientManager;
import fr.unice.polytech.tcf.domain.IngredientFinder;
import fr.unice.polytech.tcf.entities.Ingredient;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by user on 22/03/15.
 */

@RunWith(Arquillian.class)
public class AddIngredientTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                    .addPackage(Ingredient.class.getPackage())
                    .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                    .addPackage(IngredientManager.class.getPackage())
                    .addPackage(IngredientManagerBean.class.getPackage());
        }

    @EJB
    private IngredientManager im;
    @EJB
    private IngredientFinder imf;

    @Test
    public void testIngredients() {
        double prix = 100.0;
        Ingredient i = im.addIngredient("patates",prix);

//        assertNotEquals(i, new Ingredient("patates",prix));  // object is not persistent => no ID
//        assertEquals(i, imf.getIngredientByName("patates"));
//        assertEquals(imf.findAll().size(), 1);
//        im.deleteIngredient("patates");
//        assertEquals(imf.findAll().size(), 0);
    }
}

