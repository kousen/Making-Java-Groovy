package mjg

import groovy.swing.SwingBuilder

import java.awt.BorderLayout as BL
import javax.swing.ImageIcon
import javax.swing.WindowConstants as WC

String base = 'https://chart.googleapis.com/chart?'
def params = [cht:'p3', chs:'250x100', chd:'t:60,40', chl:'Hello|World']
String qs = params.collect { it }.join('&')
println "$base$qs"

params.each { k,v ->
    assert qs.contains("$k=$v")
}

new SwingBuilder().edt {
    frame(title:'Hello, Chart!', visible: true, pack: true,
        defaultCloseOperation: WC.EXIT_ON_CLOSE) {
        label(icon:new ImageIcon("$base$qs".toURL()), constraints: BL.CENTER)
    }
}
