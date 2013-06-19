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