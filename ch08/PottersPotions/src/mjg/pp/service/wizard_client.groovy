package mjg.pp.service


import javax.xml.namespace.QName 
import javax.xml.ws.Service 

import mjg.pp.entities.Cauldron;
import mjg.pp.entities.Ingredient;
import mjg.pp.entities.Potion;

// start client
Service service = Service.create(
	new URL('http://localhost:1234/wizard?WSDL'),
	new QName('http://service.pp.jag/','HogwartsWizardService'))
Wizard w = service.getPort(
	new QName('http://service.pp.jag/','HogwartsWizardPort'),
	Wizard.class)

Cauldron c = new Cauldron()
c << new Ingredient(name:'sopophorous bean',amount:1,units:'bean')
c << new Ingredient(name:'gillyleaf',amount:1,units:'handful')
println c
Potion p = w.brewPotion(c)
println p