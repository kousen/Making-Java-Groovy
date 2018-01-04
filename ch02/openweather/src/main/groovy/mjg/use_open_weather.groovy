package mjg

OpenWeather ow = new OpenWeather()
println ow.weather  // called Marlborough, CT, but really Hartford

println ow.getWeather('San Diego', 'US')

// Home of Paul King, co-author of _Groovy in Action_ and my personal hero
println ow.getWeather('Brisbane', 'Australia')

// Home of Guillaume Laforge, head of the Groovy project
// (also one of my heroes, along with Dierk Koenig, Graeme Rocher, Tom Brady, David Ortiz, ...)
println ow.getWeather('Paris', 'France')

// Have to check the weather in Java, right?
println ow.getWeather('Java','Indonesia')

// Is it always sunny in Philadelphia?
println ow.getWeather('Philadelphia', 'US')

// Any weather stations in Antarctica?
println ow.getWeather('', 'Antarctica')

// Is it colder in Denver than in Antarctica?
println ow.getWeather('Denver', 'US')
