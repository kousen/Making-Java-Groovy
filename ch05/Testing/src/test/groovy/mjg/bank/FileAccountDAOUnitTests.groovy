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
        ex.println = { data.append(it) }
        dao = new FileAccountDAO(accountsFile:ex)
    }
    
    @Test
    void testCreateAndFindNewAccount() {
        int id = dao.createNewAccount(100.0)
        Account local = new Account(id:id,balance:100.0)
        Account fromDao = dao.findAccountById(id)
        assertEquals local.id, fromDao.id
        assertEquals local.balance, fromDao.balance, 0.01
    }
    
    @Test
    void testFindAllAccounts() {
        (1..10).each { num -> dao.createNewAccount(num*100) }
        def accounts = dao.findAllAccounts()
        assertEquals 10, accounts.size()
        accounts*.balance.each { it in (100..1000) }
    }
    
    @Test
    void testDeleteAccount() {
        (1..10).each { num -> dao.createNewAccount(num*100) }
        def accounts = dao.findAllAccounts()
        assertEquals 10, accounts.size()
        accounts.each { account -> dao.deleteAccount(account.id) }
        assertEquals 0, dao.findAllAccounts().size()
    }
}
