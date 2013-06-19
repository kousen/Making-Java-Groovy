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