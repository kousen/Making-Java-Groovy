package mjg

import groovy.json.JsonOutput;

import com.google.gson.Gson

String appid = 'd82ee6ea026dd986ea1e975d14875060'
def url = "http://api.openweathermap.org/data/2.5/weather?APPID=$appid&q=marlborough,ct"
def jsonTxt = url.toURL().text
println JsonOutput.prettyPrint(jsonTxt)
Gson gson = new Gson()
println gson.fromJson(jsonTxt, Model)
