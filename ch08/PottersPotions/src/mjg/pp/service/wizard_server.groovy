package mjg.pp.service



import javax.xml.namespace.QName;

import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import mjg.pp.entities.Cauldron;
import mjg.pp.entities.Ingredient;
import mjg.pp.entities.Potion;

// start server
Wizard wiz = new HogwartsWizard(wizard:new Granger())
Endpoint e = Endpoint.publish("http://localhost:1234/wizard", wiz)
println "Wizard available to receive requests..."
