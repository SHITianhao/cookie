
package stub_manage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createCookieResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createCookieResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CookieCreated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCookieResponse", propOrder = {
    "cookieCreated"
})
public class CreateCookieResponse {

    @XmlElement(name = "CookieCreated")
    protected boolean cookieCreated;

    /**
     * Gets the value of the cookieCreated property.
     * 
     */
    public boolean isCookieCreated() {
        return cookieCreated;
    }

    /**
     * Sets the value of the cookieCreated property.
     * 
     */
    public void setCookieCreated(boolean value) {
        this.cookieCreated = value;
    }

}
