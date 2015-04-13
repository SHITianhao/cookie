package fr.unice.polytech.tcf;

import stub.TcfServiceImplService;

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
    public void showMenu(stub.TcfService port){
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
                        new Client().showMenu(port);
                        break;
                    case "2":
                        new Manager().showMenu(port);
                        break;
                    case "3":
                        new Directeur().showMenu(port);
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
        String address = "http://"+host+":8080/demo/webservices/TcfServiceImpl";
        URL wsdlLocation = null;
        try { wsdlLocation = new URL(address + "?wsdl"); } catch (Exception e) { System.exit(0); }

        // Instantiating the client stub code
        stub.TcfServiceImplService srv = new TcfServiceImplService(wsdlLocation); // dynamic WSDL location
        stub.TcfService port = srv.getTcfServiceImplPort();

        // Dynamically setting the address where the web service is really deployed
        ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);


        GregorianCalendar open = new GregorianCalendar();
        GregorianCalendar close = new GregorianCalendar();
        open.set(Calendar.HOUR_OF_DAY,7);
        open.set(Calendar.MINUTE, 30);
        close.set(Calendar.HOUR_OF_DAY,18);
        close.set(Calendar.MINUTE,0);

        try {
            port.creerBoutique("polytech",
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(open),
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(close),
                    0.19);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        port.creatIngredient("chocollaaaa",10);
        port.creatIngredient("chocho_noir",100);
        port.creatIngredient("chocho_polytech",10000);

        new ClientTerminal().showMenu(port);

    }
}
