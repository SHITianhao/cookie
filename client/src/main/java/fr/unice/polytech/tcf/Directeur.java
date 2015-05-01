package fr.unice.polytech.tcf;


/**
 * Created by sth on 09/04/15.
 */
public class Directeur {


//    private boolean creatBoutique(stub.TcfService port){
//        try {
//            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("\n############ CREATE BOUTIQUE #################\n");
//            System.out.println("Votre adresse?");
//            String address = bufferRead.readLine();
//            while(port.boutiqueIsExist(address)){
//                System.err.println("Cet adresse est dèjà existe!!");
//                System.out.print("\n#####################################\n");
//                System.out.println("Votre adresse?");
//                address = bufferRead.readLine();
//            }
//            System.out.println("Cet adresse est valable");
//
//            int oH = 0, fH = 0,oM = 0,fM = 0;
//            boolean continu = false;
//            do {
//                try {
//                    System.out.println("Votre horaire ouvert: Heure");
//                    oH = Integer.parseInt(bufferRead.readLine());
//                    System.out.println("Votre horaire ouvert: Minutes");
//                    oM = Integer.parseInt(bufferRead.readLine());
//                    System.out.println("Votre horaire ferme: Heure");
//                    fH = Integer.parseInt(bufferRead.readLine());
//                    System.out.println("Votre horaire ferme: Minutes");
//                    fM = Integer.parseInt(bufferRead.readLine());
//                    if (oH > fH || (oH == fH && oM > fM)) {
//                        System.err.println("HORAIRE FORMAT ERROR");
//                    }else
//                        continu = true;
//                }catch (NumberFormatException e){
//                    System.err.println("NumberFormatException!!");
//                }
//
//            }while (!continu);
//
//            System.out.println("Votre taxe?");
//            double taxe = Double.parseDouble(bufferRead.readLine());
//            while (taxe > 1){
//                System.err.println("Taxe, il faut être inférieur que 1");
//                System.out.println("Votre taxe?");
//                taxe = Double.parseDouble(bufferRead.readLine());
//            }
//            GregorianCalendar open = new GregorianCalendar();
//            GregorianCalendar close = new GregorianCalendar();
//            open.set(Calendar.HOUR_OF_DAY,oH);
//            open.set(Calendar.MINUTE, oM);
//            close.set(Calendar.HOUR_OF_DAY,fH);
//            close.set(Calendar.MINUTE,fM);
//
//            if (port.creerBoutique(address,
//                    DatatypeFactory.newInstance().newXMLGregorianCalendar(open),
//                    DatatypeFactory.newInstance().newXMLGregorianCalendar(close),taxe)){
//                System.out.println("Une boutique: "+address +", est crée!!");
//                return true;
//            }
//
//            return false;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (DatatypeConfigurationException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    private void creatIngredient(stub.TcfService port){
//        try {
//            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("\n############ CREATE INGREDIENT #################\n");
//            System.out.println("Nom d'ingredient?");
//            String name = bufferRead.readLine();
//            while(port.ingredientIsExist(name)){
//                System.err.println("Cet ingredient est déjà existe!");
//                System.out.println("Nom d'ingredient?");
//                name = bufferRead.readLine();
//            }
//            System.out.println("Cet nom est valable!");
//
//            boolean continu_prix = false;
//            double prix = 0;
//            while (!continu_prix){
//                System.out.println("Coût d'ingredient?");
//                try {
//                    prix = Double.parseDouble(bufferRead.readLine());
//                    continu_prix = true;
//                }catch (NumberFormatException e){
//                    System.err.println("Entrée une chiffre s'il vou plait");
//                }
//            }
//
//            if (port.creatIngredient(name,prix))
//                System.out.println("SUCCES CREER UN INGREDIENT!!");
//            else
//                System.err.println("ERROR");
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private void supIngredient(stub.TcfService port){
//        try {
//            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("\n############ SUPPRIMER INGREDIENT #################\n");
//            System.out.println("Nom d'ingredient?");
//            String name = bufferRead.readLine();
//            while(!port.ingredientIsExist(name)){
//                System.err.println("Cet ingredient n'existe pas!");
//                System.out.println("Nom d'ingredient?");
//                name = bufferRead.readLine();
//            }
//            if (port.supprimerIngredient(name))
//                System.out.println("SUCCES SUPPRIMER UN INGREDIENT!!");
//            else
//                System.err.println("ERROR");
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void listIngredients(stub.TcfService port){
//        List<String> list = port.listIngredientsDetail();
//        int j = 0;
//        System.out.println();
//        System.out.println("######## TOUS VOTRE INGREDIENTS #########");
//        for (String i : list){
//            System.out.println("["+j+"]\t"+i);
//            j++;
//        }
//        System.out.println();
//    }
//
//    public void showMenu(stub.TcfService port){
//        boolean finish = false;
//        try {
//            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//            while (!finish){
//                System.out.println();
//                System.out.println("############ DIRECTEUR MENU #############");
//                System.out.println("### [1] CRÉER UNE BOUTIQUE            ###");
//                System.out.println("### [2] CRÉER UN INGREDIENT           ###");
//                System.out.println("### [3] SUPPRIMER UN INGREDIENT       ###");
//                System.out.println("### [4] LIST INGREDIENTS              ###");
//                System.out.println("### [5] SORTIR                        ###");
//                System.out.println("#########################################");
//                System.out.print("### Votre choix:");
//                String choix = bufferRead.readLine();
//                switch (choix){
//                    case "1":
//                        creatBoutique(port);
//                        break;
//                    case "2":
//                        creatIngredient(port);
//                        break;
//                    case "3":
//                        supIngredient(port);
//                    case "4":
//                        listIngredients(port);
//                        break;
//                    case "5":
//                        finish = true;
//                        break;
//                    default:
//                        System.err.println("\nVotre choix n'est pas valide!!!");
//                }
//                System.out.println();
//            }
//            System.out.println("############ SALUT #################");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}
