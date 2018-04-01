package mjg

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class OpenWeather {
    String appid = 'd82ee6ea026dd986ea1e975d14875060'
    String base = "http://api.openweathermap.org/data/2.5/weather?APPID=$appid&q="
    Gson gson = new GsonBuilder().setFieldNamingPolicy(
            FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

    String getWeather(city='Hartford', state='US') {
        String loc = "$city,$state"
        String jsonTxt = "$base${URLEncoder.encode(loc, 'UTF-8')}".toURL().text
        gson.fromJson(jsonTxt, Model).toString()
    }

    String getWeather(String zip) {
        String loc = "$zip"
        String jsonTxt = "$base${URLEncoder.encode(loc, 'UTF-8')}".toURL().text
        gson.fromJson(jsonTxt, Model).toString()
    }
}
