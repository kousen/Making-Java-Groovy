package mjg.xml

import mjg.scripting.Location;

class GeocoderV3 {
	def base = 'http://maps.google.com/maps/api/geocode/xml?'

	def fillInLatLng(Location loc) {
        def address = loc.street ? [loc.street, loc.city, loc.state] : [loc.city, loc.state]
		def url = base + [sensor:false,
			address:address.collect { v ->
				URLEncoder.encode(v,'UTF-8')
			}.join(',+')].collect {k,v -> "$k=$v"}.join('&')
		def response = new XmlSlurper().parse(url)
		loc.latitude = response.result.geometry.location.lat.toDouble()
		loc.longitude = response.result.geometry.location.lng.toDouble()
        return loc
	}
}
