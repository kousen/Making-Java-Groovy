package mjg.pp.service


import groovy.lang.Delegate;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface="mjg.pp.service.Wizard")
@HandlerChain(file="handler-chain.xml")
class HogwartsWizard {
	@Delegate Wizard wizard
}
