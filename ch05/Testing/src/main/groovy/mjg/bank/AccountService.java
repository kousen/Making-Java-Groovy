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
