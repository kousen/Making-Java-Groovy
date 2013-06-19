/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
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
