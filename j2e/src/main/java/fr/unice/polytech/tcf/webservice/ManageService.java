package fr.unice.polytech.tcf.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sth on 24/04/15.
 */
@WebService
public interface ManageService {

    @WebMethod
    @WebResult(name = "boutiquecreated")
    public boolean createBoutique(@WebParam(name = "adresse")String adresse,
                                 @WebParam(name = "ouvert")Calendar ouvert,
                                 @WebParam(name = "fermer")Calendar fermer,
                                 @WebParam(name = "taxe")double taxe);

    @WebMethod
    @WebResult(name = "isExist")
    public boolean boutiqueIsExist(@WebParam(name = "adresse")String adresse);

    @WebMethod
    @WebResult(name = "boutique_list")
    public List<String> listBoutiques();

    @WebMethod
    @WebResult(name = "ingredient_list")
    public List<String> listIngredients();

    @WebMethod
    @WebResult(name = "created")
    public boolean creatIngredient(@WebParam(name = "name")String name,
                                   @WebParam(name = "price")double price);


    @WebMethod
    @WebResult(name = "ingredient_deleted")
    public boolean supprimerIngredient(@WebParam(name = "name")String name);

    @WebMethod
    @WebResult(name = "isExist")
    public boolean ingredientIsExist(@WebParam(name = "name")String name);

    @WebMethod
    @WebResult(name = "CookieCreated")
    public boolean createCookie(@WebParam(name = "name")String name,
                                @WebParam(name = "ingredients")List<String> ingredients);

    @WebMethod
    @WebResult(name = "cookie_deleted")
    public boolean supprimerCookie(@WebParam(name = "name")String name);

    @WebMethod
    @WebResult(name = "cookie_list")
    public List<String> listCookies();

}
