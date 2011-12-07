package mjg.pp.handlers;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class CauldronHandler implements SOAPHandler<SOAPMessageContext> {

    private CauldronProcessor cp = new CauldronProcessor();
    private boolean darkArtsDetected;

    public boolean handleMessage(SOAPMessageContext context) {
        boolean response = (Boolean) context.get(
                MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        try {
            cp.setBody(context.getMessage().getSOAPBody());
            if (!response) {
                darkArtsDetected = cp.detectDarkArts();
                cp.printInfo();
            } else {
                if (darkArtsDetected) {
                    cp.addDisclaimer();
                }
            }
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    public void close(MessageContext context) {
    }

    public Set<QName> getHeaders() {
        return null;
    }

}