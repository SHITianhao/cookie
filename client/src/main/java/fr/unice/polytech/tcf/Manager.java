package fr.unice.polytech.tcf;

/**
 * Created by sth on 10/04/15.
 */
public class Manager {


//    public void showMenu(stub.TcfService port){
//        boolean finish = false;
//        try {
//            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//            while (!finish){
//                System.out.println();
//                System.out.println("##########    MANAGER MENU   ############");
//                System.out.println("### [1] VOIR STATISTIQUE              ###");
//                System.out.println("### [2] SORTIR                        ###");
//                System.out.println("#########################################");
//                System.out.print("### Votre choix:");
//                String choix = bufferRead.readLine();
//                switch (choix){
//                    case "1":
//                        voirStatis(port);
//                        break;
//                    case "2":
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
//
//    private void voirStatis(stub.TcfService port){
//        System.out.println("###     CHOISIR UNE BOUTIQUE          ###");
//        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//        List<String> boutiques = port.listBoutiques();
//        String adresse = "";
//        int i = 0;
//        for (String b : boutiques) {
//            System.out.println("###     (" + i + ") " + b);
//            i++;
//        }
//        System.out.print("###");
//
//        try {
//
//            System.out.print("### Votre choix:");
//            String c = bufferRead.readLine();
//            boolean finish =false;
//            while (!finish){
//                try{
//                    int boutique_index = Integer.parseInt(c);
//                    if (boutique_index >= boutiques.size()){
//                        System.err.println("Cette boutique n'existe pas!");
//                    }else{
//                        finish = true;
//                        adresse = boutiques.get(boutique_index);
//                    }
//                }catch (NumberFormatException e){
//                    System.err.println("Entrée les chiffres!!");
//                }
//            }
//
//            System.out.println("############ STATISTIQUES ##############");
//            System.out.println("### [1] COMMANDES                    ###");
//            System.out.println("### [2] COOKIES                      ###");
//            System.out.println("### Votre choix");
//            String choix  = bufferRead.readLine();
//            int choix_index = 0;
//            try{
//                choix_index = Integer.parseInt(choix);
//                if (choix_index == 1)
//                    System.out.println("Dans la boutique: " + adresse + ". Il y a " + port.viewStatistiqueCommande(adresse) + " commandes");
//                if (choix_index == 2)
//                    System.out.println("Dans la boutique: " + adresse + ". Il y a " + port.viewStatistiqueCookies(adresse) + " cookies");
//            }catch (NumberFormatException e){
//                System.err.println("ENTRÉE 1 ou 2");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
