
package mjg.calc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "divideResponse", namespace = "http://service.calc.mjg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "divideResponse", namespace = "http://service.calc.mjg/")
public class DivideResponse {

    @XmlElement(name = "quotient", namespace = "")
    private double quotient;

    /**
     * 
     * @return
     *     returns double
     */
    public double getQuotient() {
        return this.quotient;
    }

    /**
     * 
     * @param quotient
     *     the value for the quotient property
     */
    public void setQuotient(double quotient) {
        this.quotient = quotient;
    }

}
