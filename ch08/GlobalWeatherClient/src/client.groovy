import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

GlobalWeatherSoap stub = new GlobalWeather().globalWeatherSoap
def xml = stub.getWeather('Ottawa', 'Canada')
root = new XmlSlurper().parseText(xml)
println "The temperature is ${root.Temperature}"