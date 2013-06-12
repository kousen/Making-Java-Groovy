package mjg

import groovy.json.JsonSlurper
import groovy.swing.SwingBuilder

import java.awt.BorderLayout as BL
import java.awt.Color
import java.awt.Font
import javax.swing.WindowConstants as WC


String base = 'http://api.icndb.com/jokes/random?limitTo=[nerdy]'
def json = new JsonSlurper().parseText(base.toURL().text)
println json?.value?.joke