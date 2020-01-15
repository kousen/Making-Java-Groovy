package mjg

import spock.lang.Specification

class OpenWeatherSpec extends Specification {
    OpenWeather ow = new OpenWeather()
    
    def 'default city and state return weather string'() {
        when:
        String result = ow.weather
        println result
        
        then:
        result
        result.contains('41.76')
        result.contains('-72.69')
    }

    def 'Hartford zip returns proper lat/lng'() {
        when:
        String result = ow.getWeather('06447')
        println result

        then:
        result
        result.contains('41.63')
        result.contains('-72.46')
    }

    def 'automatically encodes city, state'() {
        when:
        String result = ow.getWeather('San Diego', 'US')
        println result

        then:
        result
        result.contains('32.7')
        result.contains('-117.1')

    }
    
    def 'Boston, MA works'() {
        when:
        String result = ow.getWeather('Boston','US')
        println result
        
        then:
        result
        result.contains('42.36')
        result.contains('-71.06')
    }
    
    def "The weather is always great in Honolulu"() {
        when:
        String result = ow.getWeather('Honolulu', 'US')
        println result
        
        then:
        result
        result.contains('21.3')
        result.contains('-157.86')
    }
}
