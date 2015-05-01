
package stub_processCmd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stub_processCmd package. 
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

    private final static QName _AddIngredientToCookie_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "addIngredientToCookie");
    private final static QName _GetBoutiqueResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "getBoutiqueResponse");
    private final static QName _ListIngredientsDetailResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "listIngredientsDetailResponse");
    private final static QName _CreateCommand_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "createCommand");
    private final static QName _ViewStatistiqueCommande_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "viewStatistiqueCommande");
    private final static QName _GetBoutique_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "getBoutique");
    private final static QName _AddIngredientToCookieResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "addIngredientToCookieResponse");
    private final static QName _ViewStatistiqueCommandeResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "viewStatistiqueCommandeResponse");
    private final static QName _ListBoutiquesResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "listBoutiquesResponse");
    private final static QName _ValidCommande_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "validCommande");
    private final static QName _ListIngredientsDetail_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "listIngredientsDetail");
    private final static QName _CreateCommandResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "createCommandResponse");
    private final static QName _ValidCommandeResponse_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "validCommandeResponse");
    private final static QName _ListBoutiques_QNAME = new QName("http://webservice.tcf.polytech.unice.fr/", "listBoutiques");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stub_processCmd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ViewStatistiqueCommandeResponse }
     * 
     */
    public ViewStatistiqueCommandeResponse createViewStatistiqueCommandeResponse() {
        return new ViewStatistiqueCommandeResponse();
    }

    /**
     * Create an instance of {@link AddIngredientToCookieResponse }
     * 
     */
    public AddIngredientToCookieResponse createAddIngredientToCookieResponse() {
        return new AddIngredientToCookieResponse();
    }

    /**
     * Create an instance of {@link GetBoutique }
     * 
     */
    public GetBoutique createGetBoutique() {
        return new GetBoutique();
    }

    /**
     * Create an instance of {@link ViewStatistiqueCommande }
     * 
     */
    public ViewStatistiqueCommande createViewStatistiqueCommande() {
        return new ViewStatistiqueCommande();
    }

    /**
     * Create an instance of {@link ListBoutiquesResponse }
     * 
     */
    public ListBoutiquesResponse createListBoutiquesResponse() {
        return new ListBoutiquesResponse();
    }

    /**
     * Create an instance of {@link ValidCommande }
     * 
     */
    public ValidCommande createValidCommande() {
        return new ValidCommande();
    }

    /**
     * Create an instance of {@link GetBoutiqueResponse }
     * 
     */
    public GetBoutiqueResponse createGetBoutiqueResponse() {
        return new GetBoutiqueResponse();
    }

    /**
     * Create an instance of {@link AddIngredientToCookie }
     * 
     */
    public AddIngredientToCookie createAddIngredientToCookie() {
        return new AddIngredientToCookie();
    }

    /**
     * Create an instance of {@link CreateCommand }
     * 
     */
    public CreateCommand createCreateCommand() {
        return new CreateCommand();
    }

    /**
     * Create an instance of {@link ListIngredientsDetailResponse }
     * 
     */
    public ListIngredientsDetailResponse createListIngredientsDetailResponse() {
        return new ListIngredientsDetailResponse();
    }

    /**
     * Create an instance of {@link ListBoutiques }
     * 
     */
    public ListBoutiques createListBoutiques() {
        return new ListBoutiques();
    }

    /**
     * Create an instance of {@link ValidCommandeResponse }
     * 
     */
    public ValidCommandeResponse createValidCommandeResponse() {
        return new ValidCommandeResponse();
    }

    /**
     * Create an instance of {@link CreateCommandResponse }
     * 
     */
    public CreateCommandResponse createCreateCommandResponse() {
        return new CreateCommandResponse();
    }

    /**
     * Create an instance of {@link ListIngredientsDetail }
     * 
     */
    public ListIngredientsDetail createListIngredientsDetail() {
        return new ListIngredientsDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIngredientToCookie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "addIngredientToCookie")
    public JAXBElement<AddIngredientToCookie> createAddIngredientToCookie(AddIngredientToCookie value) {
        return new JAXBElement<AddIngredientToCookie>(_AddIngredientToCookie_QNAME, AddIngredientToCookie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBoutiqueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "getBoutiqueResponse")
    public JAXBElement<GetBoutiqueResponse> createGetBoutiqueResponse(GetBoutiqueResponse value) {
        return new JAXBElement<GetBoutiqueResponse>(_GetBoutiqueResponse_QNAME, GetBoutiqueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListIngredientsDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "listIngredientsDetailResponse")
    public JAXBElement<ListIngredientsDetailResponse> createListIngredientsDetailResponse(ListIngredientsDetailResponse value) {
        return new JAXBElement<ListIngredientsDetailResponse>(_ListIngredientsDetailResponse_QNAME, ListIngredientsDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCommand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "createCommand")
    public JAXBElement<CreateCommand> createCreateCommand(CreateCommand value) {
        return new JAXBElement<CreateCommand>(_CreateCommand_QNAME, CreateCommand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewStatistiqueCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "viewStatistiqueCommande")
    public JAXBElement<ViewStatistiqueCommande> createViewStatistiqueCommande(ViewStatistiqueCommande value) {
        return new JAXBElement<ViewStatistiqueCommande>(_ViewStatistiqueCommande_QNAME, ViewStatistiqueCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBoutique }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "getBoutique")
    public JAXBElement<GetBoutique> createGetBoutique(GetBoutique value) {
        return new JAXBElement<GetBoutique>(_GetBoutique_QNAME, GetBoutique.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIngredientToCookieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "addIngredientToCookieResponse")
    public JAXBElement<AddIngredientToCookieResponse> createAddIngredientToCookieResponse(AddIngredientToCookieResponse value) {
        return new JAXBElement<AddIngredientToCookieResponse>(_AddIngredientToCookieResponse_QNAME, AddIngredientToCookieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewStatistiqueCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "viewStatistiqueCommandeResponse")
    public JAXBElement<ViewStatistiqueCommandeResponse> createViewStatistiqueCommandeResponse(ViewStatistiqueCommandeResponse value) {
        return new JAXBElement<ViewStatistiqueCommandeResponse>(_ViewStatistiqueCommandeResponse_QNAME, ViewStatistiqueCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListBoutiquesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "listBoutiquesResponse")
    public JAXBElement<ListBoutiquesResponse> createListBoutiquesResponse(ListBoutiquesResponse value) {
        return new JAXBElement<ListBoutiquesResponse>(_ListBoutiquesResponse_QNAME, ListBoutiquesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "validCommande")
    public JAXBElement<ValidCommande> createValidCommande(ValidCommande value) {
        return new JAXBElement<ValidCommande>(_ValidCommande_QNAME, ValidCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListIngredientsDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "listIngredientsDetail")
    public JAXBElement<ListIngredientsDetail> createListIngredientsDetail(ListIngredientsDetail value) {
        return new JAXBElement<ListIngredientsDetail>(_ListIngredientsDetail_QNAME, ListIngredientsDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCommandResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "createCommandResponse")
    public JAXBElement<CreateCommandResponse> createCreateCommandResponse(CreateCommandResponse value) {
        return new JAXBElement<CreateCommandResponse>(_CreateCommandResponse_QNAME, CreateCommandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "validCommandeResponse")
    public JAXBElement<ValidCommandeResponse> createValidCommandeResponse(ValidCommandeResponse value) {
        return new JAXBElement<ValidCommandeResponse>(_ValidCommandeResponse_QNAME, ValidCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListBoutiques }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tcf.polytech.unice.fr/", name = "listBoutiques")
    public JAXBElement<ListBoutiques> createListBoutiques(ListBoutiques value) {
        return new JAXBElement<ListBoutiques>(_ListBoutiques_QNAME, ListBoutiques.class, null, value);
    }

}
