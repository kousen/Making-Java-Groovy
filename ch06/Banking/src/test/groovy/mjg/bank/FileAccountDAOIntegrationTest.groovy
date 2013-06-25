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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class FileAccountDAOIntegrationTest {
    FileAccountDAO dao
    
    @Before
    void setUp() {
        dao = new FileAccountDAO(accountsFile:new File('accounts.txt'))
        dao.accounts = [:]
    }
    
    @After
    void tearDown() {
        File f = new File('accounts.txt')
        if (f.exists()) f.delete()
    }
    
    @Test
    void testWriteAccountsToFile() {
        Map accounts = [1:new Account(id:1,balance:100),
                        2:new Account(id:2,balance:200)]
        dao.accounts = accounts

        dao.writeAccountsToFile()
        
        File f = new File('accounts.txt')
        assert f.exists()
        assert 2 == f.text.findAll(/\d,\d{3}/).size()
    }
    
    @Test
    void testReadAccountsFromFile() {
        File f = new File('accounts.txt')
        f.withWriter { writer -> 
            (1..5).each { id -> 
                writer.write "$id,${id*100}\n"
            }
        }
        dao.accountsFile = f
        
        assert 0 == dao.accounts.size()
        dao.readAccountsFromFile()
        assert 5 == dao.accounts.size()
    }
    
    @Test
    void testCreateAndFindNewAccount() {
        int id = dao.createNewAccount(100.0)
        Account local = new Account(id:id,balance:100.0)
        Account fromDao = dao.findAccountById(id)
        assert local.id == fromDao.id
        assertEquals(local.balance, fromDao.balance, 0.01)
    }
    
    @Test
    void testFindAllAccounts() {
        (1..10).each { num -> dao.createNewAccount(num*100) }
        def accounts = dao.findAllAccounts()
        assert 10 == accounts.size()
        accounts*.balance.each { it in (100..1000) }
    }
    
    @Test
    void testDeleteAccount() {
        (1..10).each { num -> dao.createNewAccount(num*100) }
        def accounts = dao.findAllAccounts()
        assert 10 == accounts.size()
        
        // Concurrent modification issues -- this works but need to fix it later
        Collection accountsCopy = []
        accounts.each { accountsCopy << it }
        accountsCopy.each { account -> dao.deleteAccount(account.id) }
        assert 0 == dao.findAllAccounts().size()
    }
}
