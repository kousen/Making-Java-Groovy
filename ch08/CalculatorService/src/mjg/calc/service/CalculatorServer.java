package mjg.calc.service;

import javax.xml.ws.Endpoint;

public class CalculatorServer {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1234/calc", new Calculator());
		System.out.println("Calculator ready to receive requests on port 1234...");
	}
}
