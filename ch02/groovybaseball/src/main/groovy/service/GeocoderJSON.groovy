package service

import groovy.json.JsonSlurper
import beans.Stadium

class GeocoderJSON {
    String base = 'http://maps.google.com/maps/api/geocode/json?'

    void fillInLatLng(Stadium stadium) {
        String urlEncodedAddress = 
            [stadium.street, stadium.city, stadium.state].collect { 
                URLEncoder.encode(it,'UTF-8')
            }.join(',+') 
        String url = base + [sensor:false,
            address: urlEncodedAddress].collect {k,v -> "$k=$v"}.join('&')
        println url
        def response = new JsonSlurper().parseText(url.toURL().text)
        String latitude = response.results.geometry.location.lat[0] ?: "0.0"
        String longitude = response.results.geometry.location.lng[0] ?: "0.0"
        stadium.latitude = latitude.toDouble()
        stadium.longitude = longitude.toDouble()
    }
}
