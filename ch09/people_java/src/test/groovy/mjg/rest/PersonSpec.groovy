package mjg.rest

import spock.lang.Specification

class PersonSpec extends Specification {
    
    def 'add to set to verify equals and hashcode'() {
        given: 'two equivalent people and one different one'
        Person p1 = new Person(first:'Johnathan', last:'Archer')
        Person p2 = new Person(first:'Johnathan', last:'Archer')
        Person p3 = new Person(first:'Peter Quincy', last:'Taggart')

        when: 'add them all to a set'
        Set people = [p1, p2, p3]
        
        then: 'set only contains two of them'
        people.size() == 2
        p1 == p2
        p1 != p3
    }

}
