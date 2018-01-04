package mjg

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import groovy.json.JsonOutput;

import com.google.gson.Gson

String appid = 'd82ee6ea026dd986ea1e975d14875060'
def url = "http://api.openweathermap.org/data/2.5/weather?APPID=$appid&q=marlborough,us"
def jsonTxt = url.toURL().text
println JsonOutput.prettyPrint(jsonTxt)
Gson gson = new GsonBuilder().setFieldNamingPolicy(
        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
println gson.fromJson(jsonTxt, Model)
