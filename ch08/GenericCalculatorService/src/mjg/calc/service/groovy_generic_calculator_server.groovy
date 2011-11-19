package mjg.calc.service

import javax.xml.ws.Endpoint

Calculator calc = new GenericCalculator(calc:new GroovyCalculator())
Endpoint.publish "http://localhost:1234/calc", calc
println 'Groovy Calculator ready to receive requests on port 1234...'