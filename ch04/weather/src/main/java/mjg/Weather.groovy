package mjg

class Weather {
    String city
    String region
    String country
    String condition
    String temp
    String chill
    String humidity
    
    String toString() {
        """
        Weather for $city, $region, $country:
        Condition  : $condition
        Temperature: $temp
        Wind Chill : $chill
        Humidity   : $humidity
        """
    }
}