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

package mjg.calc.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "divide", namespace = "http://service.calc.mjg/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "divide", namespace = "http://service.calc.mjg/", propOrder = {
    "x",
    "y"
})
public class Divide {

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
