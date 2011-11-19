
package mjg.calc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addResponse", namespace = "http://service.calc.mjg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addResponse", namespace = "http://service.calc.mjg/")
public class AddResponse {

    @XmlElement(name = "sum", namespace = "")
    private double sum;

    /**
     * 
     * @return
     *     returns double
     */
    public double getSum() {
        return this.sum;
    }

    /**
     * 
     * @param sum
     *     the value for the sum property
     */
    public void setSum(double sum) {
        this.sum = sum;
    }

}
