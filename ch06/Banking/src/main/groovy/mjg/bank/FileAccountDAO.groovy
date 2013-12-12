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

import java.util.concurrent.ConcurrentHashMap;


class FileAccountDAO implements AccountDAO {
    def accountsFile
    Map<Integer, Account> accounts = [:] as ConcurrentHashMap<Integer, Account>
    private static int nextId
    boolean dirty

    private void readAccountsFromFile() {
        accountsFile.splitEachLine(',') { line ->
            int id = line[0].toInteger()
            double balance = line[1].toDouble()
            accounts[id] = new Account(id:id,balance:balance)
        }
        nextId = accounts?.keySet().max() ?: 0
        nextId++
        
        dirty = false
        println accounts
    }
    
    private void writeAccountsToFile() {
        accountsFile.withWriter { w -> 
            accounts.each { id, account ->
                w.println("$id,$account.balance")
            }
        }
        dirty = true
    }
    
    @Override
    Account findAccountById(int id) {
        if (dirty) readAccountsFromFile()
        return accounts[id]
    }

    @Override
    Collection<Account> findAllAccounts() {
        if (dirty) readAccountsFromFile()
        return accounts.values()
    }

    @Override
    int createNewAccount(double balance) {
        int newId = nextId++
        accounts[newId] = new Account(id:newId,balance:balance)
        writeAccountsToFile()
        return newId;
    }

    @Override
    void deleteAccount(int id) {
        accounts.remove(id)
        writeAccountsToFile()
    }
}
