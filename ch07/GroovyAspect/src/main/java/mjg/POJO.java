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
package mjg;

public class POJO {
    private String one;
    private int two;
    private double three;
    
    public String getOne() {
        return one;
    }
    public void setOne(String one) {
        this.one = one;
    }
    public int getTwo() {
        return two;
    }
    public void setTwo(int two) {
        this.two = two;
    }
    public double getThree() {
        return three;
    }
    public void setThree(double three) {
        this.three = three;
    }
    @Override
    public String toString() {
        return "POJO [one=" + one + ", two=" + two + ", three=" + three + "]";
    }
}
