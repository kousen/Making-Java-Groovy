package mjg.bank;

public class AccountFullService {
    private AccountDAO dao;
    
    public void setDao(AccountDAO dao) {
        this.dao = dao;
    }
    
    public Account findById(int id) {
        return dao.findAccountById(id);
    }
    
    public int create(double initialBalance) {
        return dao.createNewAccount(initialBalance);
    }
    
    public void remove(int id) {
        dao.deleteAccount(id);
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
