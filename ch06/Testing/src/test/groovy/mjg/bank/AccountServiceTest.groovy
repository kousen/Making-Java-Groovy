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
