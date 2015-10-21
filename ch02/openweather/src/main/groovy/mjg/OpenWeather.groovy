package mjg

import com.google.gson.Gson

class OpenWeather {
    String appid = 'd82ee6ea026dd986ea1e975d14875060'
    String base = 'http://api.openweathermap.org/data/2.5/weather?APPID=$appid&q='
    Gson gson = new Gson()

    String getWeather(city='Marlborough', state='CT') {
        String jsonTxt = "$base$city,$state".toURL().text
        gson.fromJson(jsonTxt, Model).toString()
    }
}
