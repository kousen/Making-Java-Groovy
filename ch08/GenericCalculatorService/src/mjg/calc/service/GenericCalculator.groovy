package mjg.calc.service

import groovy.lang.Delegate;
import javax.jws.WebService;

@WebService(endpointInterface="mjg.calc.service.Calculator")
class GenericCalculator {
	@Delegate Calculator calc
}
