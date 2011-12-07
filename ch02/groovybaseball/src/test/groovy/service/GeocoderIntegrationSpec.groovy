package service;

import spock.lang.Specification
import beans.Stadium

class GeocoderIntegrationSpec extends Specification {
    Stadium stadium
    Geocoder geocoderXml
    GeocoderJSON geocoderJson
    
    def setup() {
        stadium = new Stadium(street:'1600 Ampitheatre Parkway',
            city:'Mountain View',state:'CA')
        geocoderXml = new Geocoder()
        geocoderJson = new GeocoderJSON()
    }
    
    def "fill in lat,lng using XML parsing"() {
        given:
        def google_lat = 37.422
        def google_lng = -122.083
        
        when:
        geocoderXml.fillInLatLng(stadium)

        then:
        Math.abs(stadium.latitude - google_lat) < 0.01
        Math.abs(stadium.longitude - google_lng) < 0.01
    }

    def "fill in lat,lng using JSON parsing"() {
        given:
        def google_lat = 37.422
        def google_lng = -122.083
        
        when:
        geocoderJson.fillInLatLng(stadium)

        then:
        Math.abs(stadium.latitude - google_lat) < 0.01
        Math.abs(stadium.longitude - google_lng) < 0.01
    }

}
