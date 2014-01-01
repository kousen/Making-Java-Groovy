package mjg

import spock.lang.Specification


class ModelSpec extends Specification {
    Model model = new Model()
    
    def 'convertTemp converts from Kelvin to F'() {
        expect:
        32 == model.convertTemp(273.15)
        212 == model.convertTemp(373.15)
    }
    
    def 'convertSpeed converts from meters/sec to miles/hour'() {
        expect:
        (2.23694 - model.convertSpeed(1)).abs() < 0.00001
    }
    
    def 'convertTime converts from Unix time to java.util.Date'() {
        given:
        Calendar cal = Calendar.instance
        cal.set(1992, Calendar.MAY, 5) 
        Date d = cal.time
        long time = d.time / 1000  // Java time in ms, Unix time in sec
        
        when:
        Date date = model.convertTime(time)
        
        then:
        d - date < 1
    }
}
