package mjg.rest

import groovy.sql.Sql
import spock.lang.Shared;
import spock.lang.Specification

class PersonDAOSpec extends Specification {
    @Shared PersonDAO dao = new JdbcPersonDAO()

    def 'findAll returns all people'() {
        expect:
        def people = dao.findAll()
        5 == people.size()
        ['Archer', 'Picard', 'Kirk', 'Sisko', 'Janeway'].each {
            people*.last.contains(it)
        }
    }

    def 'sample data works with findById'() {
        expect:
        Person p = dao.findById(id)
        p.first == first
        p.last == last

        where:
        [id, first, last] << JdbcPersonDAO.sql.rows('select * from people')
    }

    def 'insert and delete a new person'() {
        Person pike = new Person(first:'Christopher', last:'Pike')
 
        when:
        dao.create(pike)

        then:
        dao.findAll().size() == old(dao.findAll().size()) + 1
        pike.id

        when:
        dao.delete(pike.id)

        then:
        dao.findAll().size() == old(dao.findAll().size()) - 1
    }

    def 'findByName returns correct person'() {
        expect:
        dao.findByLastName('a').size() == 3
    }
}
