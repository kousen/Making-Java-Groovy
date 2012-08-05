package mjg;

public class RunInJava {
    public static void main(String[] args) {
        String woeid = "2367105";
        if (args.length > 0) {
            woeid = args[0];
        }
        YahooParser yp = new YahooParser();
        yp.setWoeid(woeid);
        System.out.println(yp.getWeather());
    }
}
