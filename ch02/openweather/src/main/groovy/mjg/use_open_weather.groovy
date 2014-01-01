package mjg

OpenWeather ow = new OpenWeather()
println ow.weather
println ow.getWeather('Brisbane','Australia')
println ow.getWeather('Paris','France')
println ow.getWeather('London','UK')
println ow.getWeather('Java','Indonesia')
