package collections;

public class Circle extends Shape implements Comparable<Circle> {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public int compareTo(Circle o) {
        return (int) (this.radius - o.radius);
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }

}
