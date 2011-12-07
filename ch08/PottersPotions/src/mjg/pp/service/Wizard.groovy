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
