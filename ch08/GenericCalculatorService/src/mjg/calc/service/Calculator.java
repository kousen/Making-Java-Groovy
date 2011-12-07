package mjg.calc.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface Calculator {
	@WebResult(name="sum")
	double add(
		@WebParam(name="x") double x, 
		@WebParam(name="y") double y);

	@WebResult(name="difference")
	double subtract(
		@WebParam(name="x") double x, 
		@WebParam(name="y") double y);
	
	@WebResult(name="product")
	double multiply(
		@WebParam(name="x") double x, 
		@WebParam(name="y") double y);
	
	@WebResult(name="quotient")
	double divide(
		@WebParam(name="x") double x, 
		@WebParam(name="y") double y);
}
