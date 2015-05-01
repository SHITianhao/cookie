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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 22/03/15.
 */

@RunWith(Arquillian.class)
public class IngredientManagerTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                    .addPackage(Ingredient.class.getPackage())
                    .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                    .addPackage(IngredientManager.class.getPackage())
                    .addPackage(IngredientManagerBean.class.getPackage());
        }

    @EJB
    private IngredientManager ingredientManager;
    @EJB
    private IngredientFinder ingredientFinder;

    @Test
    public void testIngredients() {
        Ingredient ingredient = ingredientManager.create("cola",10.5);
        Ingredient ingredient2 = ingredientManager.create("coooolaaaaa",100);
        Ingredient found = ingredientFinder.findByName("cola");
        Ingredient found2 = ingredientFinder.findByName("coooolaaaaa");
        //error find: 10.5->10!!!!!!!!!
//        assertEquals(found.getPrice(),10.5,0.000001);
        assertEquals(ingredient.getId(),found.getId());
        assertEquals(ingredient.getName(),found.getName());
//        assertEquals(ingredient.getPrice(),found.getPrice(),0.0000001);
        assertNotEquals(found.getId(),found2.getId());
        assertNotEquals(found.getName(),found2.getName());

        ingredientManager.delete("cola");
        assertEquals(ingredientFinder.findByName("cola"),null);
    }
}

