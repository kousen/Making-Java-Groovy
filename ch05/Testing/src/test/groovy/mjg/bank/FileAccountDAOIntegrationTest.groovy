package mjg.bank

import static org.junit.Assert.*

import org.junit.Before;
import org.junit.Test;

class FileAccountDAOIntegrationTest {
    FileAccountDAO dao
    
    @Before
    void setUp() {
        File f = new File('accounts.txt')
        if (f.exists()) f.delete()
        dao = new FileAccountDAO(accountsFile:new File('accounts.txt'))
        dao.accounts = [:]
    }
    
    @Test
    void testWriteAccountsToFile() {
        Map accounts = [1:new Account(id:1,balance:100),
                        2:new Account(id:2,balance:200)]
        dao.accounts = accounts

        dao.writeAccountsToFile()
        
        File f = new File('accounts.txt')
        assertTrue f.exists()
        assertEquals 2, f.text.findAll(/\d,\d{3}/).size()
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
        
        assertEquals 0, dao.accounts.size()
        dao.readAccountsFromFile()
        assertEquals 5, dao.accounts.size()
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
