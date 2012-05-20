package mjg

class YahooParser {
    final static String BASE = 'http://weather.yahooapis.com/forecastrss?'
    
    String woeid
    
    Weather getWeather() {
        def root = new XmlSlurper().parse(BASE + "w=$woeid")
        Weather w = new Weather(
            city:root.channel.location.@city,
            region:root.channel.location.@region,
            country:root.channel.location.@country,
            condition:root.channel.item.condition.@text,
            temp:root.channel.item.condition.@temp,
            chill:root.channel.wind.@chill,
            humidity:root.channel.atmosphere.@humidity
        )
    }
}