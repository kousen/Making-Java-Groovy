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
