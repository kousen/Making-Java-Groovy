package mjg.pp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Cauldron {
	@XmlElementWrapper(name="ingredients")
	@XmlElement(name="ingredient")
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public void addIngredient(Ingredient i) {
		ingredients.add(i);
	}
	
	public void removeIngredient(Ingredient i) {
		ingredients.remove(i);
	}
	
	public Cauldron leftShift(Ingredient i) {
		addIngredient(i);
		return this;
	}

	@Override
	public String toString() {
		return "Cauldron [ingredients=" + ingredients + "]";
	}
}
