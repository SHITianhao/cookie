
package stub_processCmd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validCommandeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validCommandeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="band" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validCommandeResponse", propOrder = {
    "band"
})
public class ValidCommandeResponse {

    protected String band;

    /**
     * Gets the value of the band property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBand() {
        return band;
    }

    /**
     * Sets the value of the band property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBand(String value) {
        this.band = value;
    }

}
