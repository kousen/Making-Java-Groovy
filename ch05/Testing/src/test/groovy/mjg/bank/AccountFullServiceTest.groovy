package mjg.bank;

import static org.junit.Assert.*
import groovy.mock.interceptor.StubFor

import org.junit.Before
import org.junit.Test

class AccountFullServiceTest {
    AccountFullService service = new AccountFullService()
    
    @Before
    public void setUp() throws Exception {
        AccountDAO dao = new StubFor(AccountDAO)
        dao.demand.findById { int id -> }
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
