package mjg;

public class CallDefMethods {
    public static void main(String[] args) {
        DefMethods dm = new DefMethods();
        String s = (String) dm.multiplyByTwo("x");
        double val = (Double) dm.multiplyByTwo(3.0);
        System.out.println(val);
        System.out.println(s);
    }
}
