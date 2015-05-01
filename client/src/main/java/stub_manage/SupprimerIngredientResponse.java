
package stub_manage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for supprimerIngredientResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="supprimerIngredientResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ingredient_deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supprimerIngredientResponse", propOrder = {
    "ingredientDeleted"
})
public class SupprimerIngredientResponse {

    @XmlElement(name = "ingredient_deleted")
    protected boolean ingredientDeleted;

    /**
     * Gets the value of the ingredientDeleted property.
     * 
     */
    public boolean isIngredientDeleted() {
        return ingredientDeleted;
    }

    /**
     * Sets the value of the ingredientDeleted property.
     * 
     */
    public void setIngredientDeleted(boolean value) {
        this.ingredientDeleted = value;
    }

}
