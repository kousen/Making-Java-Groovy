/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */

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
