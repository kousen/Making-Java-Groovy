package mjg

import com.google.gson.Gson

class OpenWeather {
    String base = 'http://api.openweathermap.org/data/2.5/weather?q='
    Gson gson = new Gson()
    
    String getWeather(city='Marlborough', state='CT') {
        String jsonTxt = "$base$city,$state".toURL().text
        gson.fromJson(jsonTxt, Model).toString()
    }
}
