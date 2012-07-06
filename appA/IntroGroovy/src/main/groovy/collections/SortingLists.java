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
package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingLists {
    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<Circle>();
        circles.add(new Circle(3));
        circles.add(new Circle(1));
        circles.add(new Circle(4));
        circles.add(new Circle(5));
        circles.add(new Circle(9));
        circles.add(new Circle(2));
        System.out.println(circles);
        Collections.sort(circles);
        System.out.println(circles);
    }
}
