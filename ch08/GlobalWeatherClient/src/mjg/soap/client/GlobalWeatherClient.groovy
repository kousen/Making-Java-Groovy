package mjg.soap.client

import groovy.util.XmlSlurper;
import net.webservicex.GlobalWeather
import net.webservicex.GlobalWeatherSoap

class GlobalWeatherClient {
    GlobalWeatherSoap stub = new GlobalWeather().globalWeatherSoap
    
    int countAvailableCitiesInCountry(countryName) {
        return getCitiesInCountry(countryName).size()
    }
    
    def getCitiesInCountry(countryName) {
        def results = new XmlParser().parseText(stub.getCitiesByCountry(countryName))
        return results.Table.City*.text()
    }
    
    String getXMLWeather(city,country) {
        return stub.getWeather(city,country)
    }
    
    Weather getWeather(city,country) {
        def results = new XmlSlurper().parseText(stub.getWeather(city, country))
        return new Weather(
            location:results.Location,
            time:results.Time,
            wind:results.Wind,
            visibility:results.Visibility,
            conditions:results.SkyConditions,
            temperature:results.Temperature,
            dewPoint:results.DewPoint,
            relativeHumidity:results.RelativeHumidity,
            pressure:results.Pressure
        )
    }
}
