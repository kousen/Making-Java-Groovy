package mjg.spring.services;

import java.util.List;

import mjg.spring.entities.Account;

public class AccountProcessor {
    private List<Account> accounts;
    
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }
    
    public double processAccounts() {
        double total = 0.0;
        for (Account account : accounts) {
            account.withdraw(1.0);
            total += 1.0;
        }
        return total;
    }
    
}
