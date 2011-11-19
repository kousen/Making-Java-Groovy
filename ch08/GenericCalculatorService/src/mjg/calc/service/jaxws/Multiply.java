
package mjg.calc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "multiply", namespace = "http://service.calc.mjg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multiply", namespace = "http://service.calc.mjg/", propOrder = {
    "x",
    "y"
})
public class Multiply {

    @XmlElement(name = "x", namespace = "")
    private double x;
    @XmlElement(name = "y", namespace = "")
    private double y;

    /**
     * 
     * @return
     *     returns double
     */
    public double getX() {
        return this.x;
    }

    /**
     * 
     * @param x
     *     the value for the x property
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * 
     * @return
     *     returns double
     */
    public double getY() {
        return this.y;
    }

    /**
     * 
     * @param y
     *     the value for the y property
     */
    public void setY(double y) {
        this.y = y;
    }

}
