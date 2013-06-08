package mjg.tos

import mjg.tng.Klingon;
import spock.lang.Specification

class TribbleSpec extends Specification {
    Tribble tribble = new Tribble()

    def "feed a tribble, get more tribbles"() {
        when:
        def result = tribble.feed()

        then:
        result.size() == 11
        result.every {
            it instanceof Tribble
        }
    }

    def "reacts well to Vulcans"() {
        Vulcan spock = Mock()
        
        when:
        String reaction = tribble.react(spock)

        then:
        reaction == "purr, purr"
        1*spock.soothe()
    }

    def "reacts badly to Klingons"() {
        Klingon koloth = Mock()
        
        when:
        String reaction = tribble.react(koloth)

        then:
        1 * koloth.annoy() >> {
            throw new Exception()
        }
        0 * koloth.howlAtDeath()
        reaction == null
        Exception e = thrown()
    }
    
    def "number of tribbles in storage compartment"() {
        given: "average litter of 10"
		// ... implementation ...
        and: "new generation every 12 hours over a period of three days"
        // ... implementation ...
        when: "tribbles get into storage compartments full of quadrotriticale"
        // invoke method
        then: "compute number of tribbles"
	    // numTribbles == 1771561
    }	
}
