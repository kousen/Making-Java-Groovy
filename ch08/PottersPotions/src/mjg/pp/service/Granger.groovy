package mjg.pp.service


import java.util.Date;

import mjg.pp.entities.Cauldron;
import mjg.pp.entities.Potion;


class Granger implements Wizard {

	@Override
	public Potion brewPotion(Cauldron c) {
		Potion p = new Potion(name:'polyguice',effect:'look like someone else',
			expiration:new Date() + 1, probability:0.8);
		p.ingredients = c.ingredients;
		return p
	}
}
