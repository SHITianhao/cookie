package fr.unice.polytech.tcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sth on 09/04/15.
 */
public class Client {

    private void passerCmd(stub_processCmd.ProcessCommandService port){
        String boutique = choisirBoutique(port);
        createCommand(port,boutique);
        choisirCookie(port);
    }

    private void valideCommande(stub_processCmd.ProcessCommandService port){
        System.out.println();
        System.out.println(port.validCommande());

    }
    private void choisirCookie(stub_processCmd.ProcessCommandService port){

        try {
            boolean finish = false;
            int choix_index = 0;
            while (!finish){
                System.out.println();
                System.out.println("### [3] CHOISIR COOKIES               ###");
                System.out.println("###     (1) COOKIES PRÉDÈFINIES       ###");
                System.out.println("###     (2) NOUVELLE COOKIE           ###");
                System.out.println("###     (3) VALIDER COMMANDER         ###");
                System.out.print("### Votre choix:");
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String choix = bufferRead.readLine();
                try{
                    choix_index = Integer.parseInt(choix);
                    switch (choix_index){
                        case 1:
                            choisirCookiesPre(port);
                            finish =false;
                            break;
                        case 2:
                            creatNouvelleCookie(port);
                            finish = false;
                            break;
                        case 3:
                            valideCommande(port);
                            finish = true;
                            break;
                        default:
                            finish = false;
                            break;
                    }
                }catch (NumberFormatException e){
                    System.err.println("Entrée les chiffres!!");
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void choisirCookiesPre(stub_processCmd.ProcessCommandService port){
        System.out.println();
        System.out.println("###     (1) COOKIES PRÉDÈFINIES     ###");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String choix = "";
        int choix_index = 0;
        try {
            boolean finish = false;
            List<String> cookies = port.listCookies();
            while (!finish){
                System.out.println("### Choisir vos cookies");
                int j = 0;
                for (String i : cookies){
                    System.out.println("### ["+j+"] "+i);
                    j++;
                }
                System.out.println("### [#] "+"FIN DE CHOSIR");
                System.out.println();
                choix = bufferRead.readLine();
                try {
                    if ("#".equals(choix)){
                        finish = true;
                    } else {
                        choix_index = Integer.parseInt(choix);
                        if (choix_index>=j){
                            System.err.println("Entrée les chiffres entre 0 et "+j);
                        } else {
                            port.chosirUnCookie(cookies.get(choix_index));
                        }
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void creatNouvelleCookie(stub_processCmd.ProcessCommandService port){
        System.out.println();
        System.out.println("###     (2) NOUVELLE COOKIE           ###");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String nomCookie = "";
        String choix = "";
        int choix_index = 0;
        try {
            System.out.print("### Nom de la cookie:");
            nomCookie = bufferRead.readLine();
            port.createNewCookie(nomCookie);
            boolean finish = false;
            List<String> ingredients = port.listIngredients();
            List<String> ingDetail = port.listIngredientsDetail();
            while (!finish){
                System.out.println("### Choisir vos ingredients");
                int j = 0;
                for (String i : ingDetail){
                    System.out.println("### ["+j+"] "+i);
                    j++;
                }
                System.out.println("### [#] "+"FIN DE CHOSIR");
                System.out.println();
                choix = bufferRead.readLine();
                try {
                    if ("#".equals(choix)){
                        finish = true;
                    } else {
                        choix_index = Integer.parseInt(choix);
                        if (choix_index>=j){
                            System.err.println("Entrée les chiffres entre 0 et "+j);
                        } else {
                            port.addIngredientToNewCookie(ingredients.get(choix_index));
                        }
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
            port.validNewCookie();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createCommand(stub_processCmd.ProcessCommandService port,String boutique){
        System.out.println();
        System.out.println("### [2] CREAT UNE COMMANDE            ###");
        System.out.print("### Votre NOM:");
        String owner = "";
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            owner = bufferRead.readLine();
            port.createCommand(owner,boutique);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    private String choisirBoutique(stub_processCmd.ProcessCommandService port){
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            boolean finish = false;
            List<String> boutiques = new ArrayList<>();
            int boutique_index = 0;
            while (!finish){
                System.out.println();
                System.out.println("######## PASSER UNE COMMANDE ############");
                System.out.println("### [1] CHOISIR UNE BOUTIQUE          ###");

                boutiques = port.listBoutiques();
                int i = 0;
                for (String b : boutiques) {
                    System.out.println("###     (" + i + ") " + b);
                    i++;
                }
                System.out.print("###");
                System.out.print("### Votre choix:");
                String choix = bufferRead.readLine();

                try{
                    boutique_index = Integer.parseInt(choix);
                    if (boutique_index >= boutiques.size()){
                        System.err.println("Cette boutique n'existe pas!");
                    }else
                        finish = true;
                }catch (NumberFormatException e){
                    System.err.println("Entrée les chiffres!!");
                }

            }
            return boutiques.get(boutique_index);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void showMenu(stub_processCmd.ProcessCommandService port){
        boolean finish = false;
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            while (!finish){
                System.out.println();
                System.out.println("##########    CLIENT MENU   #############");
                System.out.println("### [1] PASSER UNE COMMANDE           ###");
                System.out.println("### [2] SORTIR                        ###");
                System.out.println("#########################################");
                System.out.print("### Votre choix:");
                String choix = bufferRead.readLine();
                switch (choix){
                    case "1":
                        passerCmd(port);
                        break;
                    case "2":
                        finish = true;
                        break;
                    default:
                        System.err.println("\nVotre choix n'est pas valide!!!");
                }
                System.out.println();
            }
            System.out.println("############ SALUT #################");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
