package mjg.bank;

public class Account {
    private int id;
    private double balance;
    
    public Account() {}
    
    public Account(double balance) {
        this(999, balance);
    }
    
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", balance=" + balance + "]";
    }
    
    
}
