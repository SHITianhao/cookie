
package stub_processCmd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getBoutiqueResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getBoutiqueResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="boutique_Detail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBoutiqueResponse", propOrder = {
    "boutiqueDetail"
})
public class GetBoutiqueResponse {

    @XmlElement(name = "boutique_Detail")
    protected String boutiqueDetail;

    /**
     * Gets the value of the boutiqueDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoutiqueDetail() {
        return boutiqueDetail;
    }

    /**
     * Sets the value of the boutiqueDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoutiqueDetail(String value) {
        this.boutiqueDetail = value;
    }

}
