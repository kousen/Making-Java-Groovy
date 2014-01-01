package mjg

class Model {
    Long dt
    Long id
    String name
    Integer cod
    
    Coordinates coord
    Main main
    System sys
    Wind wind
    Clouds clouds 
    Weather[] weather
    
    def convertTemp(temp) {
        9 * (temp - 273.15) / 5 + 32
    }
    
    def convertSpeed(mps) {
        // 1 m/sec * 60 sec/min * 60 min/hr * 100 cm/m * 1 in/2.54 cm * 1 ft/12 in * 1 mi/5280 ft
        mps * 60 * 60 * 100 / 2.54 / 12 / 5280
    }
    
    def convertTime(t) {
        new Date(t*1000)  // Unix time in sec, Java time in ms
    }
    
    def getTime() { convertTime dt }
    def getLatitude() { coord.lat }
    def getLongitude() { coord.lon }
    def getTemperature() { convertTemp main.temp }
    def getLow() { convertTemp main.temp_min }
    def getHigh() { convertTemp main.temp_max }
    def getSunrise() { convertTime sys.sunrise }
    def getSunset() { convertTime sys.sunset }
    def getSpeed() { convertSpeed wind.speed }
    
    String toString() {
        """
        Name         : $name
        Time         : $time
        Location     : ($latitude, $longitude)
        Weather      : ${weather[0].main} (${weather[0].description})
        Icon         : http://openweathermap.org/img/w/${weather[0].icon}.png
        Current Temp : $temperature F (high: $high F, low: $low F)
        Humidity     : ${main.humidity}%
        Sunrise      : $sunrise
        Sunset       : $sunset
        Wind         : $speed mph at ${wind.deg} deg
        Cloudiness   : ${clouds.all}%
        """
    }
}

class Main {
    BigDecimal temp
    BigDecimal humidity
    BigDecimal pressure
    BigDecimal temp_min
    BigDecimal temp_max
}

class Coordinates {
    BigDecimal lat
    BigDecimal lon
}

class Weather {
    Integer id
    String main
    String description
    String icon
}

class System {
    String message
    String country
    Long sunrise
    Long sunset
}

class Wind {
    BigDecimal speed
    BigDecimal deg
}

class Clouds {
    BigDecimal all
}