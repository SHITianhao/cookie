package fr.unice.polytech.tcf.domain.impl;

/**
 * Created by sth on 08/04/15.
 */

import fr.unice.polytech.tcf.domain.HelloWorld;
import fr.unice.polytech.tcf.entities.Boutique;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class HelloWorldTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Boutique.class.getPackage())
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(HelloWorld.class.getPackage())
                .addPackage(HelloWordBean.class.getPackage());
    }

    @EJB
    HelloWordBean helloWordBean = new HelloWordBean();

    @Test
    public void testHello(){
        assertEquals(helloWordBean.sayHello("JULIEN"),"Hello JULIEN");
    }

    @Test
    public void testTime() {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY,7);
        c2.set(Calendar.HOUR_OF_DAY,16);
        assertTrue(c1.before(c2));
    }
}
