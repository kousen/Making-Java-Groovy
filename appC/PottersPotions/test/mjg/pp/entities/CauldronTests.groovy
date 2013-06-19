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
package mjg.pp.entities


import mjg.pp.entities.Cauldron;
import mjg.pp.entities.Ingredient;
import spock.lang.Specification;

class CauldronTests extends Specification {
	Cauldron c
	
	def setup() {
		c = new Cauldron()
	}
	
	def "cauldron starts off empty"() {
		expect: c.ingredients.size() == 0
	}
	
	def "add ingredient increases size by 1"() {
		when: 
		c.addIngredient(new Ingredient())
		
		then:
		c.ingredients.size() == old(c.ingredients.size()) + 1
	}
	
	def "remove ingredient decreases size by 1"() {
		given:
		Ingredient i = new Ingredient()
		c.addIngredient(i)
		c.addIngredient(new Ingredient())
		
		when:
		c.removeIngredient(i)
		
		then:
		c.ingredients.size() == old(c.ingredients.size()) - 1
	}
	
	def "left shift operator adds ingredient"() {
		when:
		c << new Ingredient()
		
		then:
		c.ingredients.size() == old(c.ingredients.size()) + 1
	}
	
	def "left shift operator can be chained"() {
		when:
		c << new Ingredient(name:'a') << new Ingredient(name:'b')
		
		then:
		c.ingredients*.name.containsAll 'a','b'
	}
}
