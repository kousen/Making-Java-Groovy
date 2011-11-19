package mjg.calc.service

import javax.xml.ws.Endpoint;

Calculator calc = new GenericCalculator(calc:new JavaCalculator())
Endpoint.publish "http://localhost:1234/calc", calc
println 'Java Calculator ready to receive requests on port 1234...'