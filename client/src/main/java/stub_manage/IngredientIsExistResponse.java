
package stub_manage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ingredientIsExistResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ingredientIsExistResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isExist" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingredientIsExistResponse", propOrder = {
    "isExist"
})
public class IngredientIsExistResponse {

    protected boolean isExist;

    /**
     * Gets the value of the isExist property.
     * 
     */
    public boolean isIsExist() {
        return isExist;
    }

    /**
     * Sets the value of the isExist property.
     * 
     */
    public void setIsExist(boolean value) {
        this.isExist = value;
    }

}
