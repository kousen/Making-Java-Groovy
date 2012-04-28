url = 'http://weather.yahooapis.com/forecastrss?w=2480318'
def root = new XmlSlurper().parse(url)
println( root.channel.location.@city )
