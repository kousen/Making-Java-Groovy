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
package mjg.spring.dao

import mjg.spring.entities.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import spock.lang.Specification;

@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
class JdbcAccountDAOSpec extends Specification {
    @Autowired
    AccountDAO dao
    
    def "dao is injected properly"() {
        expect: dao
    }
    
    def "find 3 accounts in sample db"() {
        expect: dao.findAllAccounts().size() == 3
    }
    
    def "find account 0 by id"() {
        when:
        Account account = dao.findAccountById(0)
        
        then:
        account.id == 0
        account.balance == 100.0
    }
    
    def "create account and find it"() {
        when:
        int newId = dao.createAccount(500.0)
        Account account = dao.findAccountById(newId)
        
        then:
        account.id == newId
        account.balance == 500.0
    }
    
    def "update account changes balance"() {
        given:
        Account account = dao.findAccountById(0)
        account.balance = 1000.0
        
        when:
        dao.updateAccount account
        Account a = dao.findAccountById(0)
        
        then:
        a.balance == 1000.0
    }
    
    def "delete all accounts"() {
        when:
        dao.findAllAccounts().each { Account a ->
            dao.deleteAccount a.id
        }
        
        then:
        dao.findAllAccounts().size() == 0
    }
}
