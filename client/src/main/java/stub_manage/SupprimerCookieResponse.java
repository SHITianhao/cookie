
package stub_manage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for supprimerCookieResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="supprimerCookieResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cookie_deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supprimerCookieResponse", propOrder = {
    "cookieDeleted"
})
public class SupprimerCookieResponse {

    @XmlElement(name = "cookie_deleted")
    protected boolean cookieDeleted;

    /**
     * Gets the value of the cookieDeleted property.
     * 
     */
    public boolean isCookieDeleted() {
        return cookieDeleted;
    }

    /**
     * Sets the value of the cookieDeleted property.
     * 
     */
    public void setCookieDeleted(boolean value) {
        this.cookieDeleted = value;
    }

}
