package mjg.spring.aspects

import java.util.logging.Logger

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

@Aspect
class AccountAspect {
	Logger log = Logger.getLogger(AccountAspect.class.name)
	
	@Pointcut("execution(* mjg..Account.deposit(*))")
	void deposits() {}
	
	@Pointcut("execution(* mjg..Account.withdraw(*))")
	void withdrawals() {}
	
	@Pointcut("execution(* mjg..Account.getBalance())")
	void balances() {}
	
	@Before("balances() || deposits() || withdrawals()")
	void audit(JoinPoint jp) {
		String method = jp.signature.name
		log.info("$method called with ${jp.args} on ${jp.target}")
	}
	
//	@Before("execution(* mjg..Account.set*(*))")
//	void trackSet(JoinPoint jp) {
//		String method = jp.signature.name
//		String property = (method - 'set')[0].toLowerCase() + (method - 'set')[1..-1]
//		def current = jp.target."$property"
//		log.info("$method changing $property from $current to ${jp.args[0]}")
//	}
//	
//	@Before("execution(* mjg..AccountDAO.*(..))")
//	void auditDao(JoinPoint jp) {
//		String method = jp.signature.name
//		log.info("$method called with ${jp.args} on ${jp.target}")
//	}
	
	@Before("execution(* mjg..AccountService.*(..))")
	void auditService(JoinPoint jp) {
		String method = jp.signature.name
		log.info("$method called with ${jp.args} on ${jp.target}")
	}
}
