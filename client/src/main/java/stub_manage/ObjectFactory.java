
package stub_manage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stub_mange package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IngredientIsExistResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "ingredientIsExistResponse");
    private final static QName _CreerBoutique_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "creerBoutique");
    private final static QName _CreatIngredientResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "creatIngredientResponse");
    private final static QName _BoutiqueIsExist_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "boutiqueIsExist");
    private final static QName _CreatIngredient_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "creatIngredient");
    private final static QName _IngredientIsExist_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "ingredientIsExist");
    private final static QName _CreerBoutiqueResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "creerBoutiqueResponse");
    private final static QName _BoutiqueIsExistResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "boutiqueIsExistResponse");
    private final static QName _ListIngredients_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "listIngredients");
    private final static QName _ListIngredientsResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "listIngredientsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stub_mange
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreerBoutiqueResponse }
     * 
     */
    public CreerBoutiqueResponse createCreerBoutiqueResponse() {
        return new CreerBoutiqueResponse();
    }

    /**
     * Create an instance of {@link IngredientIsExist }
     * 
     */
    public IngredientIsExist createIngredientIsExist() {
        return new IngredientIsExist();
    }

    /**
     * Create an instance of {@link ListIngredientsResponse }
     * 
     */
    public ListIngredientsResponse createListIngredientsResponse() {
        return new ListIngredientsResponse();
    }

    /**
     * Create an instance of {@link ListIngredients }
     * 
     */
    public ListIngredients createListIngredients() {
        return new ListIngredients();
    }

    /**
     * Create an instance of {@link BoutiqueIsExistResponse }
     * 
     */
    public BoutiqueIsExistResponse createBoutiqueIsExistResponse() {
        return new BoutiqueIsExistResponse();
    }

    /**
     * Create an instance of {@link CreerBoutique }
     * 
     */
    public CreerBoutique createCreerBoutique() {
        return new CreerBoutique();
    }

    /**
     * Create an instance of {@link IngredientIsExistResponse }
     * 
     */
    public IngredientIsExistResponse createIngredientIsExistResponse() {
        return new IngredientIsExistResponse();
    }

    /**
     * Create an instance of {@link CreatIngredient }
     * 
     */
    public CreatIngredient createCreatIngredient() {
        return new CreatIngredient();
    }

    /**
     * Create an instance of {@link BoutiqueIsExist }
     * 
     */
    public BoutiqueIsExist createBoutiqueIsExist() {
        return new BoutiqueIsExist();
    }

    /**
     * Create an instance of {@link CreatIngredientResponse }
     * 
     */
    public CreatIngredientResponse createCreatIngredientResponse() {
        return new CreatIngredientResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngredientIsExistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "ingredientIsExistResponse")
    public JAXBElement<IngredientIsExistResponse> createIngredientIsExistResponse(IngredientIsExistResponse value) {
        return new JAXBElement<IngredientIsExistResponse>(_IngredientIsExistResponse_QNAME, IngredientIsExistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreerBoutique }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "creerBoutique")
    public JAXBElement<CreerBoutique> createCreerBoutique(CreerBoutique value) {
        return new JAXBElement<CreerBoutique>(_CreerBoutique_QNAME, CreerBoutique.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatIngredientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "creatIngredientResponse")
    public JAXBElement<CreatIngredientResponse> createCreatIngredientResponse(CreatIngredientResponse value) {
        return new JAXBElement<CreatIngredientResponse>(_CreatIngredientResponse_QNAME, CreatIngredientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoutiqueIsExist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "boutiqueIsExist")
    public JAXBElement<BoutiqueIsExist> createBoutiqueIsExist(BoutiqueIsExist value) {
        return new JAXBElement<BoutiqueIsExist>(_BoutiqueIsExist_QNAME, BoutiqueIsExist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatIngredient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "creatIngredient")
    public JAXBElement<CreatIngredient> createCreatIngredient(CreatIngredient value) {
        return new JAXBElement<CreatIngredient>(_CreatIngredient_QNAME, CreatIngredient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngredientIsExist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "ingredientIsExist")
    public JAXBElement<IngredientIsExist> createIngredientIsExist(IngredientIsExist value) {
        return new JAXBElement<IngredientIsExist>(_IngredientIsExist_QNAME, IngredientIsExist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreerBoutiqueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "creerBoutiqueResponse")
    public JAXBElement<CreerBoutiqueResponse> createCreerBoutiqueResponse(CreerBoutiqueResponse value) {
        return new JAXBElement<CreerBoutiqueResponse>(_CreerBoutiqueResponse_QNAME, CreerBoutiqueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoutiqueIsExistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "boutiqueIsExistResponse")
    public JAXBElement<BoutiqueIsExistResponse> createBoutiqueIsExistResponse(BoutiqueIsExistResponse value) {
        return new JAXBElement<BoutiqueIsExistResponse>(_BoutiqueIsExistResponse_QNAME, BoutiqueIsExistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListIngredients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "listIngredients")
    public JAXBElement<ListIngredients> createListIngredients(ListIngredients value) {
        return new JAXBElement<ListIngredients>(_ListIngredients_QNAME, ListIngredients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListIngredientsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "listIngredientsResponse")
    public JAXBElement<ListIngredientsResponse> createListIngredientsResponse(ListIngredientsResponse value) {
        return new JAXBElement<ListIngredientsResponse>(_ListIngredientsResponse_QNAME, ListIngredientsResponse.class, null, value);
    }

}
