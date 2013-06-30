/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package mjg.spring.config

import mjg.spring.aspects.AccountAspect
import mjg.spring.dao.AccountDAO
import mjg.spring.entities.Account

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Scope

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
class GroovyConfig {
    @Autowired
    AccountDAO dao
    
    @Bean @Scope("prototype")
    Account prototypeAccount() {
        int newId = dao.createAccount(100.0)
        new Account(id:newId,balance:100.0)
    }
	
	@Bean
	AccountAspect accountAspect() {
		new AccountAspect()
	}
}
