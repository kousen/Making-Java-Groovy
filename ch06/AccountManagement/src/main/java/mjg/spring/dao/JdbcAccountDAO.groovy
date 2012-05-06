package mjg.spring.dao

import mjg.spring.entities.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

import java.sql.ResultSet
import javax.sql.DataSource

@Repository
class JdbcAccountDAO implements AccountDAO {
    static int nextId = 3
    JdbcTemplate jdbcTemplate

    @Autowired JdbcAccountDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource)
    }

    public int createAccount(double initialBalance) {
        String sql = "insert into accounts(id,balance) values(?,?)"
        Account account = new Account(id: nextId++, balance: initialBalance)
        jdbcTemplate.update(sql, account.id, account.balance)
        return account.id;
    }

    public Account findAccountById(int id) {
        String sql = "select * from accounts where id=?"
        jdbcTemplate.queryForObject(sql, accountMapper as RowMapper<Account>, id)
    }

    public List<Account> findAllAccounts() {
        String sql = "select * from accounts"
        jdbcTemplate.query(sql, accountMapper as RowMapper<Account>)
    }

    void updateAccount(Account account) {
        String sql = "update accounts set balance=? where id=?"
        jdbcTemplate.update(sql, account.balance, account.id)
    }

    public void deleteAccount(int id) {
        String sql = "delete from accounts where id=?"
        jdbcTemplate.update(sql, id)
    }

    def accountMapper = { ResultSet rs, int row ->
        new Account(id: rs.getInt('id'), balance: rs.getDouble('balance'))
    }
}
