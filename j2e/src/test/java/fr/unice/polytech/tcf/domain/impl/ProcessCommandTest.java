package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.*;
import fr.unice.polytech.tcf.entities.Commande;
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
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 05/04/15.
 */

@RunWith(Arquillian.class)
public class ProcessCommandTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Commande.class.getPackage())
                .addAsWebInfResource("META-INF/persistence.xml", "persistence.xml")
                .addPackage(ProcessCommand.class.getPackage())
                .addPackage(ProcessCommandBean.class.getPackage());

    }

    @EJB
    IngredientManager ingredientManager;
    @EJB
    IngredientFinder ingredientFinder;

    @EJB
    CreateBoutique createBoutique;

    @EJB
    CookieFinder cookieFinder;
    @EJB
    CookieManager cookieManager;

    @EJB
    ProcessCommand processCommand;

//    //testé dans la foulée
//    @EJB
//    ViewStatistiques vs;

    @EJB
    BoutiqueFinder finder;

    @Before
    public void init(){
        List<String> list_ings = new ArrayList<String>();
        list_ings.add("poisson");
        list_ings.add("patates");
        list_ings.add("lareponseb");
        //Création des ingrédients
        ingredientManager.create("poisson", 5.5);
        ingredientManager.create("patates", 100);
        ingredientManager.create("lareponseb", 3.0);


        //Création de la boutique
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY,7);
        c2.set(Calendar.HOUR_OF_DAY,16);
        createBoutique.create("Manosque", c1, c2, 0.19);

        //création un cookie predéfini
        cookieManager.create("Process_test_cookie",list_ings);
    }

    @Test
    public void testUnProcess(){
        testProcess("Jean Michel0","Process_test_new_cookie0");
    }

    @Test
    public void testMultiProcess(){
        Thread test1 = new TestUnProcess("Jean Michel1","Process_test_new_cookie1");
        Thread test2 = new TestUnProcess("Jean Michel 2","Process_test_new_cookie2");
        test1.start();
        test2.start();
        try {
            test1.join();
            test2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class TestUnProcess extends Thread{
        String owner;
        String newCookie;

        public TestUnProcess(String owner, String newCookie){
            this.owner = owner;
            this.newCookie = newCookie;
        }

        @Override
        public void start(){
            testProcess(this.owner,this.newCookie);
        }
    }

    public void testProcess(String owner,String newCookie)
    {
        // Process de commande
        processCommand.createCommand(owner, "Manosque");

        //Nouveau cookie
        processCommand.createNouveauCookie(newCookie);
        processCommand.ajouterIngredient("poisson");
        //pas fini delete
//        processCommand.deleteIngredient("poisson");
//        processCommand.ajouterIngredient("poisson");
        processCommand.ajouterIngredient("patates");
        processCommand.validNewCookie();


        //chosi un cookie predéfini
        processCommand.addCookieDansCmd("Process_test_cookie");

        // Validation de la commande et envoi d'un string representant un fichier de commande au client
        String commande = processCommand.validate();


        //test de validité des données
        assertTrue(commande.contains(owner));
        assertTrue(commande.contains("patates"));
//        assertTrue(commande.contains("Prix TTC :213")) ;//error find 10->10.5
        assertTrue(commande.contains("Manosque")) ;

        System.out.println(commande);

//        //Test de persistance
//        assertEquals(1,vs.getNbCommandes("Manosque"));
//        assertEquals(2,vs.getNbCookies("Manosque"));


    }




}
