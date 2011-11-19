package mjg.spring.services

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

import spock.lang.Specification

@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
class AccountServiceSpec extends Specification {
    @Autowired
    AccountService service
    
    def "balance of test account is 100"() {
        expect: service.getAccountBalance(0) == 100.0
    }
    
    def "deposit into account increases balance"() {
        when:
        double newBalance = service.depositIntoAccount(0,100)
        
        then:
        newBalance == 200
        service.getAccountBalance(0) == old(service.getAccountBalance(0)) + 100
    }
    
    def "withdraw from account decreases balance"() {
        when:
        double newBalance = service.withdrawFromAccount(0,50)
        
        then:
        newBalance == 50.0
        service.getAccountBalance(0) == old(service.getAccountBalance(0)) - 50
    }
    
    def "transfer funds works"() {
        when:
        service.transferFunds(0,1,25.0)
        
        then:
        service.getAccountBalance(0) == old(service.getAccountBalance(0)) - 25.0
        service.getAccountBalance(1) == old(service.getAccountBalance(1)) + 25.0
    }
}
