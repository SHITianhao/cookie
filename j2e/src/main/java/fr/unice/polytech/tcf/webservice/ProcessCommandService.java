

package fr.unice.polytech.tcf.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProcessCommandService {

    @WebMethod
    @WebResult(name = "boutique_Detail")
    public String getBoutique(@WebParam(name = "adresse")String adresse);

//
//    @WebMethod
//    @WebResult(name = "created")
//    public boolean createCommand(@WebParam(name = "owner") String owner,@WebParam(name = "boutique") String boutique);

    @WebMethod
    @WebResult(name = "ingredient_list")
    public List<String> listIngredientsDetail();

//
//    @WebMethod
//    @WebResult(name = "deleted")
//    public boolean supprimerIngredient(@WebParam(name = "name")String name);

    @WebMethod
    @WebResult
    public void addIngredientToCookie(@WebParam(name = "name")String name);

    //    @WebMethod
//    @WebResult(name = "IngredientAdded")
//    public boolean addIngredient(@WebParam(name = "ingredient")String ingredient);
//
//    @WebMethod
//    @WebResult(name = "validated")
//    public void validate();

    @WebMethod
    @WebResult(name = "all_boutiques")
    public List<String> listBoutiques();

    @WebMethod
    public void createCommand(@WebParam(name = "owner")String owner,
                              @WebParam(name = "magasin")String magasin);

    @WebMethod
    @WebResult(name = "band")
    public String validCommande();

//
//    @WebMethod
//    @WebResult(name = "statsboutique")
//    public String getStats(String boutique);
//
//    @WebMethod
//    @WebResult(name = "statsglobal")
//    public String getStatsGlobal();

    @WebMethod
    @WebResult(name = "statis_nbCommande")
    public int viewStatistiqueCommande(@WebParam(name = "adresse")String adress);
//
//
//    @WebMethod
//    @WebResult(name = "statis_nbCookie")
//    public int viewStatistiqueCookies(@WebParam(name = "adresse")String adress);
//
//    @WebMethod
//    @WebResult(name = "all_cookies")
//    public List<String> listAllCookies();
//
//    @WebMethod
//    @WebResult(name = "all_cookies")
//    public void choisirCookiePre(@WebParam(name = "name")String name);
}