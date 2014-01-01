package mjg

import groovy.json.JsonOutput;

import com.google.gson.Gson

def url = "http://api.openweathermap.org/data/2.5/weather?q=marlborough,ct"
def jsonTxt = url.toURL().text
println JsonOutput.prettyPrint(jsonTxt)
Gson gson = new Gson()
println gson.fromJson(jsonTxt, Model)