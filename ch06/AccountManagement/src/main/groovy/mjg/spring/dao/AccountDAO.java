package mjg.spring.dao;

import java.util.List;

import mjg.spring.entities.Account;

public interface AccountDAO {
    int createAccount(double initialBalance);
    Account findAccountById(int id);
    List<Account> findAllAccounts();
    void updateAccount(Account account);
    void deleteAccount(int id);
}
