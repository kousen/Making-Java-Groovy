def address = [street,city,state].collect {
	URLEncoder.encode(it,'UTF-8')
}.join(',+')
def params = [q:address,sensor:false,
	output:'csv',
	key:'ABQIAAAAaUTtvoQeYKO5TqAv0hl2QxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxTU9rH8s89rxCtRwCKUkQ3Q6sYsNg']
def base = 'http://maps.google.com/maps/geo?'
def url = base + params.collect { k,v -> "$k=$v" }.join('&')
(code,level,lat,lng) = url.toURL().text.split(',')
//println "($code,$level,$lat,$lng)"