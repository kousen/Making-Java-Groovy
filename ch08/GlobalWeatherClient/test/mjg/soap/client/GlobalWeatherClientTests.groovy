package mjg.soap.client

import spock.lang.Specification;

class GlobalWeatherClientTests extends Specification {
    GlobalWeatherClient client
    
    def setup() {
        client = new GlobalWeatherClient()
    }
    
    def "at least 561 cities in Canada"() {
        expect:
        client.countAvailableCitiesInCountry('Canada') >= 561
    }
    
    def "Australian cities includes Sydney Airport"() {
        expect:
        client.getCitiesInCountry("Australia").contains 'Sydney Airport'
    }
    
    def "Weather for Boston, MA"() {
        when:
        Weather w = client.getWeather('Boston', "United States")
        println w
        
        then:
        w.location ==~ /.*BOSTON.*/
    }
}
