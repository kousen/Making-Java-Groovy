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
package mjg.bank

import static org.junit.Assert.*

import org.junit.Before;
import org.junit.Test;

class FileAccountDAOUnitTests {
    FileAccountDAO dao
    
    @Before
    void setUp() {
        Expando ex = new Expando()
        ex.data = ''
        ex.splitEachLine = { pattern, clos -> data.splitEachLine(pattern, clos) }
        ex.withWriter = { new StringWriter() }
//        ex.println = { data.append(it) }
        dao = new FileAccountDAO(accountsFile:ex)
    }
    
    @Test
    void testCreateAndFindNewAccount() {
        int id = dao.createNewAccount(100.0)
        println dao.accountsFile
        Account local = new Account(id:id,balance:100.0)
        Account fromDao = dao.findAccountById(id)
        assert local.id == fromDao.id
        assertEquals local.balance, fromDao.balance, 0.01
    }
    
    @Test
    void testFindAllAccounts() {
        (1..10).each { num -> dao.createNewAccount(num*100) }
        println dao.accountsFile
        def accounts = dao.findAllAccounts()
        assert 10 == accounts.size()
        accounts*.balance.each { it in (100..1000) }
    }
    
    @Test
    void testDeleteAccount() {
        (1..10).each { num -> dao.createNewAccount(num*100) }
        def accounts = dao.findAllAccounts()
        assert 10 == accounts.size()
        accounts.each { account -> dao.deleteAccount(account.id) }
        assert 0 == dao.findAllAccounts().size()
    }
}
