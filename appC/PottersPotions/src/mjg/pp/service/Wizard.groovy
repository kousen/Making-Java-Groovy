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



import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import mjg.pp.entities.Cauldron;
import mjg.pp.entities.Potion;

@WebService
interface Wizard {
	
	@WebResult(name="potion")
	Potion brewPotion(@WebParam(name="cauldron") Cauldron c);
}
