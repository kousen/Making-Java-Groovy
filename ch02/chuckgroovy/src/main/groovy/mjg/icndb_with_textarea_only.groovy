package mjg

import groovy.json.JsonSlurper
import groovy.swing.SwingBuilder

import java.awt.BorderLayout as BL
import java.awt.Color
import java.awt.Font

import javax.swing.WindowConstants as WC


String base = 'http://api.icndb.com/jokes/random?limitTo=[nerdy]'
def json = new JsonSlurper().parseText(base.toURL().text)
String joke = json?.value?.joke

new SwingBuilder().edt {
    frame(title:'ICNDB', visible: true, pack: true,
        defaultCloseOperation:WC.EXIT_ON_CLOSE) {
        panel(layout:new BL(), preferredSize:[300, 250], background: Color.WHITE) {
            scrollPane {
                textArea(joke, 
                    constraints:BL.NORTH,
                    font: new Font('Serif', Font.PLAIN, 24),
                    lineWrap: true,
                    wrapStyleWord: true,
                    editable: false)
            }
        }
    }
}