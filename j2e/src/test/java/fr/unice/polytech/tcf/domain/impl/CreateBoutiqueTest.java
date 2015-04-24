package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.*;
import fr.unice.polytech.tcf.entities.Boutique;
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
public class CreateBoutiqueTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Boutique.class.getPackage())
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(CreateBoutique.class.getPackage())
                .addPackage(CreateBoutiqueBean.class.getPackage());
    }

    @EJB
    private CreateBoutique manager;

    @EJB
    private BoutiqueFinder finder;
    @EJB
    CookieManager cookieManager;
    @EJB
    IngredientManager ingredientManager;

    @PersistenceContext
    EntityManager entityManager;

    Calendar c1;
    Calendar c2;

    @Before
    public void init(){
        c1 = Calendar.getInstance();
        c2 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY,7);
        c2.set(Calendar.HOUR_OF_DAY,16);
    }

    @Test
    public void testCreation()  {
        Boutique boutique;
        boutique = manager.create("Polytech_create", c1, c2, 0.19);
        Boutique boutique2 = manager.create("Polytechnique", c1, c2, 0.19);
        assertEquals(boutique.getEndroit(), "Polytech_create");
        Boutique found = finder.findByEndroit("Polytech_create");
        Boutique found2 = finder.findByEndroit("Polytech_create");
//        assertEquals(finder.listBoutiques().size(), 2);
        assertEquals(found.getId(), found2.getId());
        assertNotEquals(boutique.getEndroit(), boutique2.getEndroit());
        assertEquals(boutique.getHoraireClose(), found.getHoraireClose());
    }

}
