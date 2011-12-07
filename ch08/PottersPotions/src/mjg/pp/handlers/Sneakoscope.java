package mjg.pp.handlers;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

public class Sneakoscope implements LogicalHandler<LogicalMessageContext> {

	public boolean handleMessage(LogicalMessageContext context) {
		boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (!outbound) {
			try {
				Transformer xf = TransformerFactory.newInstance().newTransformer();
				xf.transform(context.getMessage().getPayload(), new StreamResult(System.out));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean handleFault(LogicalMessageContext context) {
		return false;
	}

	public void close(MessageContext context) {}
	
}