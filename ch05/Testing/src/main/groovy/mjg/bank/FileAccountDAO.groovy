package mjg.bank

import java.util.List;

class FileAccountDAO implements AccountDAO {
    def accountsFile
    Map<Integer, Account> accounts = [:]
    private static int nextId
    boolean dirty

    void readAccountsFromFile() {
        accountsFile.splitEachLine(',') { line ->
            int id = line[0].toInteger()
            double balance = line[1].toDouble()
            accounts[id] = new Account(id:id,balance:balance)
        }
        nextId = accounts?.keySet().max() ?: 0
        nextId++
        
        dirty = false
    }
    
    void writeAccountsToFile() {
        accountsFile.withWriter { w -> 
            accounts.each { id, account ->
                w.println("$id,$account.balance")
            }
        }
        dirty = true
    }
    
    @Override
    public Account findAccountById(int id) {
        if (dirty) readAccountsFromFile()
        return accounts[id]
    }

    @Override
    public List<Account> findAllAccounts() {
        if (dirty) readAccountsFromFile()
        return accounts.values() as List
    }

    @Override
    public int createNewAccount(double balance) {
        int newId = nextId++
        accounts[newId] = new Account(id:newId,balance:balance)
        writeAccountsToFile()
        return newId;
    }

    @Override
    public void deleteAccount(int id) {
        accounts.remove(id)
        writeAccountsToFile()
    }

}
