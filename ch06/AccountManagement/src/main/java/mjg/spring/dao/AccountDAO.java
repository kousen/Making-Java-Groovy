package mjg.spring.dao;

import mjg.spring.entities.Account;

import java.util.List;

public interface AccountDAO {
    int createAccount(double initialBalance);

    Account findAccountById(int id);

    List<Account> findAllAccounts();

    void updateAccount(Account account);

    void deleteAccount(int id);
}
