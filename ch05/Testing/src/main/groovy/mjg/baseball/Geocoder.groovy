package mjg.baseball

class Geocoder {
    String base = 'http://maps.google.com/maps/api/geocode/xml?'
    
        void fillInLatLng(Stadium stadium) {
            String urlEncodedAddress =
                [stadium.street, stadium.city, stadium.state].collect {
                    URLEncoder.encode(it,'UTF-8')
                }.join(',+')
            String url = base + [sensor:false,
                address: urlEncodedAddress].collect { it }.join('&')
            def response = new XmlSlurper().parse(url)
            String latitude =
                response.result.geometry.location.lat[0] ?: "0.0"
            String longitude =
                response.result.geometry.location.lng[0] ?: "0.0"
            stadium.latitude = latitude.toDouble()
            stadium.longitude = longitude.toDouble()
        }
    
}
