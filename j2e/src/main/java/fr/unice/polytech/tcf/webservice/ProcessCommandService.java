

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
    public String getBoutique(@WebParam(name = "adresse") String adresse);

    @WebMethod
    @WebResult(name = "all_boutiques")
    public List<String> listBoutiques();

    @WebMethod
    @WebResult(name = "ingredient_list")
    public List<String> listIngredients();

    @WebMethod
    @WebResult(name = "ingredient_list")
    public List<String> listIngredientsDetail();

    @WebMethod
    @WebResult(name = "cookie_list")
    public List<String> listCookies();

    @WebMethod
    public void createCommand(@WebParam(name = "owner") String owner,
                              @WebParam(name = "magasin") String magasin);

    @WebMethod
    public void chosirUnCookie(@WebParam(name = "name") String name);

    @WebMethod
    public void createNewCookie(@WebParam(name = "name") String name);

    @WebMethod
    public void addIngredientToNewCookie(@WebParam(name = "name") String name);

    @WebMethod
    public void validNewCookie();

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

//    @WebMethod
//    @WebResult(name = "statis_nbCommande")
//    public int viewStatistiqueCommande(@WebParam(name = "adresse")String adress);
//
//
//    @WebMethod
//    @WebResult(name = "statis_nbCookie")
//    public int viewStatistiqueCookies(@WebParam(name = "adresse")String adress);
}