package mjg.bank;

import java.util.List;

public interface AccountDAO {
    Account findAccountById(int id);
    List<Account> findAllAccounts();
    int createNewAccount(double balance);
    void deleteAccount(int id);
}
