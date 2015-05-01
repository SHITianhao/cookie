
package stub_manage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for createBoutique complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createBoutique">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ouvert" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fermer" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="taxe" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createBoutique", propOrder = {
    "adresse",
    "ouvert",
    "fermer",
    "taxe"
})
public class CreateBoutique {

    protected String adresse;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ouvert;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fermer;
    protected double taxe;

    /**
     * Gets the value of the adresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets the value of the adresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Gets the value of the ouvert property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOuvert() {
        return ouvert;
    }

    /**
     * Sets the value of the ouvert property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOuvert(XMLGregorianCalendar value) {
        this.ouvert = value;
    }

    /**
     * Gets the value of the fermer property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFermer() {
        return fermer;
    }

    /**
     * Sets the value of the fermer property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFermer(XMLGregorianCalendar value) {
        this.fermer = value;
    }

    /**
     * Gets the value of the taxe property.
     * 
     */
    public double getTaxe() {
        return taxe;
    }

    /**
     * Sets the value of the taxe property.
     * 
     */
    public void setTaxe(double value) {
        this.taxe = value;
    }

}
