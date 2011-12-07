
package mjg.calc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "multiplyResponse", namespace = "http://service.calc.mjg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multiplyResponse", namespace = "http://service.calc.mjg/")
public class MultiplyResponse {

    @XmlElement(name = "product", namespace = "")
    private double product;

    /**
     * 
     * @return
     *     returns double
     */
    public double getProduct() {
        return this.product;
    }

    /**
     * 
     * @param product
     *     the value for the product property
     */
    public void setProduct(double product) {
        this.product = product;
    }

}
