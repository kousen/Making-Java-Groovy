
package mjg.calc.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for divideResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="divideResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="quotient" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "divideResponse", propOrder = {
    "quotient"
})
public class DivideResponse {

    protected double quotient;

    /**
     * Gets the value of the quotient property.
     * 
     */
    public double getQuotient() {
        return quotient;
    }

    /**
     * Sets the value of the quotient property.
     * 
     */
    public void setQuotient(double value) {
        this.quotient = value;
    }

}
