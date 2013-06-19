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
