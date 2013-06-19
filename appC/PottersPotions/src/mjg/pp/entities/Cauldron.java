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
