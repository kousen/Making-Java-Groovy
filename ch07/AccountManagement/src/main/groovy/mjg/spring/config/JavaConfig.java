package mjg.spring.config;

import mjg.spring.dao.AccountDAO;
import mjg.spring.services.AccountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Autowired
    private AccountDAO accountDAO;

    @Bean
    public AccountProcessor accountProcessor() {
        AccountProcessor ap = new AccountProcessor();
        ap.setAccounts(accountDAO.findAllAccounts());
        return ap;
    }
}
