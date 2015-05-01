package fr.unice.polytech.tcf;

import stub_manage.ManageServiceImplService;
import stub_processCmd.ProcessCommandServiceImplService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.BindingProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by sth on 10/04/15.
 */
public class ClientTerminal {
    public void showMenu(stub_manage.ManageService port_m, stub_processCmd.ProcessCommandService port_cmd){
        boolean finish = false;
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            while (!finish){
                System.out.println("########## BIENVENUE CHEZ TCF ###########");
                System.out.println("###                                   ###");
                System.out.println("### [1] VOUS ÊTES CLIENT              ###");
                System.out.println("### [2] VOUS ÊTES MANAGER             ###");
                System.out.println("### [3] VOUS ÊTES CADRE DIRIGEANTE    ###");
                System.out.println("### [4] SORTIR                        ###");
                System.out.println("#########################################");
                System.out.print("### Votre choix:");
                String choix = bufferRead.readLine();
                switch (choix){
                    case "1":
//                        new Client().showMenu(port_m);
                        break;
                    case "2":
//                        new Manager().showMenu(port_cmd);
                        break;
                    case "3":
//                        new Directeur().showMenu(null);
                        break;
                    case "4":
                        finish = true;
                        break;
                    default:
                        System.err.println("\nVotre choix n'est pas valide!!!");
                }
            }
            System.out.println("############ SALUT #################");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

        // Dynamically building the targeted web service location (default to localhost if not provided)
        String host = ( args.length == 0 ? "localhost" : args[0]);
        String address_m = "http://"+host+":8080/demo/webservices/ManageServiceImpl";
        String address_cmd = "http://"+host+":8080/demo/webservices/ProcessCommandServiceImpl";

        URL wsdlLocation_m = null;
        URL wsdlLocation_cmd = null;
        try { wsdlLocation_m = new URL(address_m + "?wsdl"); } catch (Exception e) { System.exit(0); }
        try { wsdlLocation_cmd = new URL(address_cmd + "?wsdl"); } catch (Exception e) { System.exit(0); }

        // Instantiating the client stub_manage code
        stub_manage.ManageServiceImplService srv_m = new ManageServiceImplService(wsdlLocation_m); // dynamic WSDL location
        stub_manage.ManageService port_m = srv_m.getManageServiceImplPort();

        // Instantiating the client stub_manage code
        stub_processCmd.ProcessCommandServiceImplService srv_cmd = new ProcessCommandServiceImplService(wsdlLocation_cmd); // dynamic WSDL location
        stub_processCmd.ProcessCommandService port_cmd = srv_cmd.getProcessCommandServiceImplPort();

        // Dynamically setting the address where the web service is really deployed
        ((BindingProvider) port_m).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address_m);
        // Dynamically setting the address where the web service is really deployed
        ((BindingProvider) port_cmd).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address_cmd);

        GregorianCalendar open = new GregorianCalendar();
        GregorianCalendar close = new GregorianCalendar();
        open.set(Calendar.HOUR_OF_DAY,7);
        open.set(Calendar.MINUTE, 30);
        close.set(Calendar.HOUR_OF_DAY,18);
        close.set(Calendar.MINUTE,0);

        try {
            port_m.creerBoutique("polytech",
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(open),
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(close),
                    0.19);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        port_m.creatIngredient("chocollaaaa",10);
        port_m.creatIngredient("chocho_noir",100);
        port_m.creatIngredient("chocho_polytech",10000);

        new ClientTerminal().showMenu(port_m,port_cmd);

    }
}
