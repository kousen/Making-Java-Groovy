package mjg.soap.client

class Weather {
    String location
    String time
    String wind
    String visibility
    String conditions
    String temperature
    String dewPoint
    String relativeHumidity
    String pressure
    
    String toString() {
        return """Weather for $location:
            Time: $time, 
            Wind: $wind,
            Visibility: $visibility,
            Conditions: $conditions,
            Temperature: $temperature,
            Dew Point: $dewPoint,
            Humidity: $relativeHumidity,
            Pressure: $pressure
        """
    }
}
