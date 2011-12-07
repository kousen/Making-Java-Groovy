package mjg.pp.entities;

import java.util.Date;
import java.util.List;

public class Potion {
	private String name;
	private String effect;
	private Date expiration;
	private double probability;
	
	private List<Ingredient> ingredients;
	
	public Potion() {}
	
	public Potion(String name, String effect, Date expiration) {
		this.name = name;
		this.effect = effect;
		this.expiration = expiration;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public double getProbability() {
		return probability;
	}
	public void setProbability(double probability) {
		this.probability = probability;
	}
	@Override
	public String toString() {
		return "Potion [name=" + name + ", effect=" + effect + ", expiration="
				+ expiration + ", probability=" + probability + "]";
	}
}
