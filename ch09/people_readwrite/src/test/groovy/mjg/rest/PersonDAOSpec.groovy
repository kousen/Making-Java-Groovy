package mjg.rest

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PersonDAOSpec extends Specification {
    @Shared PersonDAO dao = JdbcPersonDAO.instance
    @Shared Sql sql = Sql.newInstance(url:'jdbc:h2:db', driver:'org.h2.Driver')
    
    def 'findAll returns all people'() {
        when:
        def people = dao.findAll()
        
        then:
        5 == people.size()
        ['Archer', 'Picard', 'Kirk', 'Sisko', 'Janeway'].every {
            people*.last.contains(it)
        }
    }

    @Unroll
    def 'findById returns #first #last with id #id'() {
        expect:
        Person p = dao.findById(id)
        p.first == first
        p.last == last

        where:
        [id, first, last] << sql.rows('select id, first, last from people')
    }

    def 'insert and delete a new person'() {
        Person taggart = new Person(first:'Peter Quincy', last:'Taggart')
 
        when:
        dao.create(taggart)

        then:
        dao.findAll().size() == old(dao.findAll().size()) + 1
        taggart.id

        when:
        dao.delete(taggart.id)

        then:
        dao.findAll().size() == old(dao.findAll().size()) - 1
    }

    def 'findByName returns correct person'() {
        expect:
        dao.findByLastName('a').size() == 3
    }
    
    def 'get min and max ids'() {
        expect:
        dao.minId == 1
        dao.maxId == 5
    }
}
