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
