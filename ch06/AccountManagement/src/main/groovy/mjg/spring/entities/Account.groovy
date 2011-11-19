package mjg.spring.entities

class Account {
    Integer id
    Double balance
    
    double deposit(double amount) {
        balance += amount
    }
    
    double withdraw(double amount) {
        balance -= amount
    }
}
