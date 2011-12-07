package service

import spock.lang.Shared;
import spock.lang.Specification;
import spock.lang.Unroll;
import groovy.sql.Sql

class StadiumLocationsSpec extends Specification {
    @Shared Sql db
    
    def setupSpec() {
        db = Sql.newInstance(
            'jdbc:h2:~/build/baseball', 
            'org.h2.Driver')
    }
    
    @Unroll({"$name: $lat and $lng in range"})
    def "lat and lngs are reasonable"() {
        expect:
        lat > 25 && lat < 48
        lng > -123 && lng < -71
        
        where:
        [name,lat,lng] << db.rows('select name,latitude,longitude from stadium')
    }
}
