package mjg

OpenWeather ow = new OpenWeather()
println ow.weather  // called Marlborough, CT, but really Hartford
println ow.getWeather('Brisbane','Australia')
println ow.getWeather('Paris','France')
println ow.getWeather('London','UK')
println ow.getWeather('Java','Indonesia')
