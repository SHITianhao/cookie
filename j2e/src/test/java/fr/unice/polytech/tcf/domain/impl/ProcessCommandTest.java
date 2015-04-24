package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.ProcessCommand;
import fr.unice.polytech.tcf.entities.Commande;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

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
//
//    @EJB
//    private IngredientManager im;
//
//    @EJB
//    private BoutiqueManager bm;
//
//    @EJB
//    private ProcessCommand pc;
//
//    //testé dans la foulée
//    @EJB
//    ViewStatistiques vs;
//
//    @EJB
//    BoutiqueFinder finder;
//
//
//    @Test
//    public void testProcess()
//    {
//        //Création des ingrédients
//        im.addIngredient("poisson",5.5);
//        im.addIngredient("patates",100);
//        im.addIngredient("lareponseb",3.0);
//
//
//        //Création de la boutique
//        Calendar c1 = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//        c1.set(Calendar.HOUR_OF_DAY,7);
//        c2.set(Calendar.HOUR_OF_DAY,16);
//        bm.create("Manosque", c1, c2, 0.19);
//
//
//
//        // Process de commande
//        pc.createCommand("Jean Michel", "Manosque");
//
//        pc.ajouterIngredient("poisson");
//
//        pc.ajouterIngredient("poisson");
//        pc.deleteIngredient("poisson");
//        pc.ajouterIngredient("patates");
//
//        //Nouveau cookie
//        pc.ajouterCookie();
//
//        pc.ajouterIngredient("poisson");
//
//        //test OK
//        assertEquals(pc.listBoutiques().size(), 1);
//
//        // Validation de la commande et envoi d'un string representant un fichier de commande au client
//        String commande = pc.validate();
//
//
//        //test de validité des données
//        assertTrue(commande.contains("Jean Michel"));
//        assertTrue(commande.contains("patates"));
//        assertTrue(commande.contains("Prix TTC :136.85")) ;
//        assertTrue(commande.contains("Manosque")) ;
//
//        //Test de persistance
//        assertEquals(1,vs.getNbCommandes("Manosque"));
//        assertEquals(2,vs.getNbCookies("Manosque"));
//
//
//    }



}
