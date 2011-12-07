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
