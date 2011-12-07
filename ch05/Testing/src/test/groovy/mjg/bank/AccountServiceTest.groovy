package mjg.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class AccountServiceTest {
    AccountService service = new AccountService()
    Account a1 = new Account(1,100)
    Account a2 = new Account(2,100)
    def accounts = [1:a1, 2:a2] 

    @Before
    public void setUp() throws Exception {
        service.dao = { id -> accounts[id] } as AccountDAO
    }

    @Test
    public void testTransferFunds() {
        assertEquals 100, a1.balance, 0.01
        assertEquals 100, a2.balance, 0.01
        
        service.transferFunds(1, 2, 50)
        
        assertEquals 50, a1.balance, 0.01
        assertEquals 150, a2.balance, 0.01
    }

}
