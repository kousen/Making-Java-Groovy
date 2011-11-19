
package mjg.pp.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "brewPotion", namespace = "http://service.pp.mjg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "brewPotion", namespace = "http://service.pp.mjg/")
public class BrewPotion {

    @XmlElement(name = "cauldron", namespace = "")
    private mjg.pp.entities.Cauldron cauldron;

    /**
     * 
     * @return
     *     returns Cauldron
     */
    public mjg.pp.entities.Cauldron getCauldron() {
        return this.cauldron;
    }

    /**
     * 
     * @param cauldron
     *     the value for the cauldron property
     */
    public void setCauldron(mjg.pp.entities.Cauldron cauldron) {
        this.cauldron = cauldron;
    }

}
