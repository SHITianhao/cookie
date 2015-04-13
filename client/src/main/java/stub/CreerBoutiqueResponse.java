
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creerBoutiqueResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creerBoutiqueResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="boutiquecreated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creerBoutiqueResponse", propOrder = {
    "boutiquecreated"
})
public class CreerBoutiqueResponse {

    protected boolean boutiquecreated;

    /**
     * Gets the value of the boutiquecreated property.
     * 
     */
    public boolean isBoutiquecreated() {
        return boutiquecreated;
    }

    /**
     * Sets the value of the boutiquecreated property.
     * 
     */
    public void setBoutiquecreated(boolean value) {
        this.boutiquecreated = value;
    }

}
