package mjg.rest

import groovy.sql.Sql
import spock.lang.Shared;
import spock.lang.Specification

class CustomerDAOSpec extends Specification {
    @Shared CustomerDAO dao = new JdbcCustomerDAO()

    def 'findAll returns all customers'() {
        expect:
        def customers = dao.findAll()
        5 == customers.size()
        ['Archer', 'Picard', 'Kirk', 'Sisko', 'Janeway'].each {
            customers*.last.contains(it)
        }
    }

    def 'sample data works with findById'() {
        expect:
        Customer c = dao.findById(id)
        c.first == first
        c.last == last

        where:
        [id, first, last] << JdbcCustomerDAO.sql.rows('select * from customers')
    }

    def 'insert and delete a new customer'() {
        Customer pike = new Customer(first:'Christopher', last:'Pike')
 
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

    def 'findByName returns correct customer'() {
        expect:
        dao.findByLastName('a').size() == 3
    }
}
