package mjg.calc.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class Calculator {

    @WebResult(name="sum")
    public double add(
            @WebParam(name="x") double x, 
            @WebParam(name="y") double y) {
        return x+y;
    }

    @WebResult(name="difference")
    public double subtract(
            @WebParam(name="x") double x, 
            @WebParam(name="y") double y) {
        return x-y;
    }

    @WebResult(name="product")
    public double multiply(
            @WebParam(name="x") double x, 
            @WebParam(name="y") double y) {
        return x*y;
    }

    @WebResult(name="quotient")
    public double divide(
            @WebParam(name="x") double x, 
            @WebParam(name="y") double y) {
        return x/y;
    }
}
