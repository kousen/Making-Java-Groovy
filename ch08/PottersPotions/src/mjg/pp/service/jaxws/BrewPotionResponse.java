
package mjg.pp.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "brewPotionResponse", namespace = "http://service.pp.mjg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "brewPotionResponse", namespace = "http://service.pp.mjg/")
public class BrewPotionResponse {

    @XmlElement(name = "potion", namespace = "")
    private mjg.pp.entities.Potion potion;

    /**
     * 
     * @return
     *     returns Potion
     */
    public mjg.pp.entities.Potion getPotion() {
        return this.potion;
    }

    /**
     * 
     * @param potion
     *     the value for the potion property
     */
    public void setPotion(mjg.pp.entities.Potion potion) {
        this.potion = potion;
    }

}
