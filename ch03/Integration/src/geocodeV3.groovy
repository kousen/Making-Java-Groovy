// undeclared street, city, state part of binding
String encoded = [street,city,state].collect {
	URLEncoder.encode(it,'UTF-8')
}.join(',')
String qs = [address: encoded, sensor: false].collect { it }.join('&')
String base = 'http://maps.googleapis.com/maps/api/geocode/xml?'
println "$base$qs"
def root = new XmlSlurper().parse("$base$qs")

// undeclared lat, lng part of binding
lat = root.result[0].geometry.location.lat.toString()
lng = root.result[0].geometry.location.lng.toString()
println "($lat,$lng)"