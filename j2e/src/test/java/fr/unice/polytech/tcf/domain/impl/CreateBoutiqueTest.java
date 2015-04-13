package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.BoutiqueFinder;
import fr.unice.polytech.tcf.domain.BoutiqueManager;
import fr.unice.polytech.tcf.entities.Boutique;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
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
                .addPackage(BoutiqueManager.class.getPackage())
                .addPackage(BoutiqueManagerBean.class.getPackage());
    }

    @EJB
    private BoutiqueManager manager;

    @EJB
    private BoutiqueFinder finder;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void testCreation()  {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY,7);
        c2.set(Calendar.HOUR_OF_DAY,16);
        Boutique boutique = manager.create("Polytech", c1, c2, 0.19);
        Boutique boutique2 = manager.create("Polytechnique", c1, c2, 0.19);
        assertEquals(boutique.getEndroit(), "Polytech");
        Boutique found = finder.findByEndroit("Polytech");
        assertEquals(finder.listBoutiques().size(), 2);
        assertEquals(found.getEndroit(), boutique.getEndroit());
        assertNotEquals(boutique.getEndroit(), boutique2.getEndroit());
        assertEquals(boutique.getHoraireClose(), found.getHoraireClose());

        }
}
