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

public class AccountService {
    private AccountDAO dao;
    
    public void setDao(AccountDAO dao) {
        this.dao = dao;
    }
    
    public void transferFunds(int from, int to, double amount) {
        Account fromAccount = dao.findAccountById(from);
        Account toAccount = dao.findAccountById(to);
        
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
    
    public double getBalance(int id) {
        return dao.findAccountById(id).getBalance();
    }
}
