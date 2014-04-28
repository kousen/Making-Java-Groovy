package mjg.pojo;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public BigDecimal withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
        return this.balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (balance != null ? !balance.equals(account.balance) : account.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return balance != null ? balance.hashCode() : 0;
    }

}
