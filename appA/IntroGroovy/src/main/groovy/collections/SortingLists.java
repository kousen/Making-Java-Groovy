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
