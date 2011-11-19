package mjg.spring.services

import mjg.spring.dao.AccountDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

import spock.lang.Specification

@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
class AccountProcessorSpec extends Specification {
    @Autowired
    AccountProcessor accountProcessor
    
    @Autowired
    AccountDAO dao
    
    def "processing test accounts should yield 3"() {
        given:
        def accounts = dao.findAllAccounts()
         
        when: 
        def result = accountProcessor.processAccounts()
        
        then:
        result == 3.0
        accounts.each { account ->
             account.balance.toString().endsWith "9"   
        }
    }
}
