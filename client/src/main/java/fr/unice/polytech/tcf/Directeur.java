package fr.unice.polytech.tcf;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by sth on 09/04/15.
 */
public class Directeur {


    private boolean creatBoutique(stub_manage.ManageService port){
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\n############ CREATE BOUTIQUE #################\n");
            System.out.println("Votre adresse?");
            String address = bufferRead.readLine();
            while(port.boutiqueIsExist(address)){
                System.err.println("Cet adresse est dèjà existe!!");
                System.out.print("\n#####################################\n");
                System.out.println("Votre adresse?");
                address = bufferRead.readLine();
            }
            System.out.println("Cet adresse est valable");

            int oH = 0, fH = 0,oM = 0,fM = 0;
            boolean continu = false;
            do {
                try {
                    System.out.println("Votre horaire ouvert: Heure");
                    oH = Integer.parseInt(bufferRead.readLine());
                    System.out.println("Votre horaire ouvert: Minutes");
                    oM = Integer.parseInt(bufferRead.readLine());
                    System.out.println("Votre horaire ferme: Heure");
                    fH = Integer.parseInt(bufferRead.readLine());
                    System.out.println("Votre horaire ferme: Minutes");
                    fM = Integer.parseInt(bufferRead.readLine());
                    if (oH > fH || (oH == fH && oM > fM)) {
                        System.err.println("HORAIRE FORMAT ERROR");
                    }else
                        continu = true;
                }catch (NumberFormatException e){
                    System.err.println("NumberFormatException!!");
                }

            }while (!continu);

            System.out.println("Votre taxe?");
            double taxe = Double.parseDouble(bufferRead.readLine());
            while (taxe > 1){
                System.err.println("Taxe, il faut être inférieur que 1");
                System.out.println("Votre taxe?");
                taxe = Double.parseDouble(bufferRead.readLine());
            }
            GregorianCalendar open = new GregorianCalendar();
            GregorianCalendar close = new GregorianCalendar();
            open.set(Calendar.HOUR_OF_DAY,oH);
            open.set(Calendar.MINUTE, oM);
            close.set(Calendar.HOUR_OF_DAY,fH);
            close.set(Calendar.MINUTE,fM);

            if (port.createBoutique(address,
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(open),
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(close),taxe)){
                System.out.println("Une boutique: "+address +", est crée!!");
                return true;
            }

            return false;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void listBoutiques(stub_manage.ManageService port){
        List<String> list = port.listBoutiques();
        int j = 0;
        System.out.println();
        System.out.println("######## TOUS VOTRE BOUTIQUES #########");
        for (String i : list){
            System.out.println("["+j+"]\t"+i);
            j++;
        }
        System.out.println();
    }

    private void creatIngredient(stub_manage.ManageService port){
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\n############ CREATE INGREDIENT #################\n");
            System.out.println("Nom d'ingredient?");
            String name = bufferRead.readLine();
            while(port.ingredientIsExist(name)){
                System.err.println("Cet ingredient est déjà existe!");
                System.out.println("Nom d'ingredient?");
                name = bufferRead.readLine();
            }
            System.out.println("Cet nom est valable!");

            boolean continu_prix = false;
            double prix = 0;
            while (!continu_prix){
                System.out.println("Coût d'ingredient?");
                try {
                    prix = Double.parseDouble(bufferRead.readLine());
                    continu_prix = true;
                }catch (NumberFormatException e){
                    System.err.println("Entrée une chiffre s'il vou plait");
                }
            }

            if (port.creatIngredient(name,prix))
                System.out.println("SUCCES CREER UN INGREDIENT!!");
            else
                System.err.println("ERROR");

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void supIngredient(stub_manage.ManageService port){
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\n############ SUPPRIMER INGREDIENT #################\n");
            System.out.println("Nom d'ingredient?");
            String name = bufferRead.readLine();
            while(!port.ingredientIsExist(name)){
                System.err.println("Cet ingredient n'existe pas!");
                System.out.println("Nom d'ingredient?");
                name = bufferRead.readLine();
            }
            if (port.supprimerIngredient(name))
                System.out.println("SUCCES SUPPRIMER INGREDIENT: "+ name);
            else
                System.err.println("ERROR");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listIngredients(stub_manage.ManageService port){
        int j = 0;
        System.out.println();
        System.out.println("######## TOUS VOTRE INGREDIENTS #########");
        for (String i : port.listIngredients()){
            System.out.println("["+j+"]\t"+i);
            j++;
        }
        System.out.println();
    }

        private void creatNouvelleCookie(stub_manage.ManageService port){
        System.out.println();
        System.out.println("###         NOUVELLE COOKIE           ###");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String nomCookie = "";
        String choix = "";
        List<String> ings = new ArrayList<>();
        int choix_index = 0;
        try {
            System.out.print("### Nom de la cookie:");
            nomCookie = bufferRead.readLine();
            boolean finish = false;
            while (!finish){
                System.out.println("### Choisir vos ingredients");
                List<String> ingredients = port.listIngredients();
                List<String> ingDetail = port.listIngredients();
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
                            ings.add(ingredients.get(choix_index));
                        }
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
            port.createCookie(nomCookie,ings);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void supCookie(stub_manage.ManageService port){
        listCookies(port);
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\n############ SUPPRIMER COOKIE #################\n");
            System.out.println("Nom de cookie?");
            String name = bufferRead.readLine();
            if (port.supprimerCookie(name))
                System.out.println("SUCCES SUPPRIMER COOKIE: "+ name);
            else
                System.err.println("ERROR");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCookies(stub_manage.ManageService port){
        int j = 0;
        System.out.println();
        System.out.println("######## TOUS VOTRE COOKIES     #########");
        for (String i : port.listCookies()){
            System.out.println("["+j+"]\t"+i);
            j++;
        }
        System.out.println();
    }

    public void showMenu(stub_manage.ManageService port){
        boolean finish = false;
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            while (!finish){
                System.out.println();
                System.out.println("############ DIRECTEUR MENU #############");
                System.out.println("### [1] CRÉER UNE BOUTIQUE            ###");
                System.out.println("### [2] LIST BOUTIQUES                ###");
                System.out.println("### [3] CRÉER UN INGREDIENT           ###");
                System.out.println("### [4] SUPPRIMER UN INGREDIENT       ###");
                System.out.println("### [5] LIST INGREDIENTS              ###");
                System.out.println("### [6] CRÉER UN COOKIE               ###");
                System.out.println("### [7] SUPPRIMER UN COOKIE           ###");
                System.out.println("### [8] LIST COOKIES                  ###");
                System.out.println("### [9] SORTIR                        ###");
                System.out.println("#########################################");
                System.out.print("### Votre choix:");
                String choix = bufferRead.readLine();
                switch (choix){
                    case "1":
                        creatBoutique(port);
                        break;
                    case "2":
                        listBoutiques(port);
                        break;
                    case "3":
                        creatIngredient(port);
                        break;
                    case "4":
                        supIngredient(port);
                    case "5":
                        listIngredients(port);
                        break;
                    case "6":
                        creatNouvelleCookie(port);
                        break;
                    case "7":
                        supCookie(port);
                        break;
                    case "8":
                        listCookies(port);
                        break;
                    case "9":
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
