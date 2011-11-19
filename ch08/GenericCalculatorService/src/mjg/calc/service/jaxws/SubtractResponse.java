
package mjg.calc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "subtractResponse", namespace = "http://service.calc.mjg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subtractResponse", namespace = "http://service.calc.mjg/")
public class SubtractResponse {

    @XmlElement(name = "difference", namespace = "")
    private double difference;

    /**
     * 
     * @return
     *     returns double
     */
    public double getDifference() {
        return this.difference;
    }

    /**
     * 
     * @param difference
     *     the value for the difference property
     */
    public void setDifference(double difference) {
        this.difference = difference;
    }

}
