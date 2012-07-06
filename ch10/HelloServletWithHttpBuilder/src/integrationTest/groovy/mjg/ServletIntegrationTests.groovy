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
package mjg;

import static org.junit.Assert.*;

import groovyx.net.http.ContentType;
import groovyx.net.http.HTTPBuilder
import org.junit.Test;

class ServletIntegrationTests {
    def httpPort = 8163
    
    @Test
    void testHelloServlet() {
        String response = "http://localhost:$httpPort/HelloServletWithHttpBuilder/hello".toURL().text.trim()
        assert response == 'Hello, Servlet!'
    }
    
    @Test
    void testHelloGroovyServlet() {
        String response = "http://localhost:$httpPort/HelloServletWithHttpBuilder/hellogs".toURL().text.trim()
        assert response == 'Hello from a Groovy Servlet!'
    }
    
    @Test
    void testHelloServletGetWithHttpBuilder() {
        def http = new HTTPBuilder("http://localhost:$httpPort/")
        def resp = http.get(path:'HelloServletWithHttpBuilder/hellogs', 
            contentType: ContentType.TEXT) { resp, reader ->
            reader.text.trim()
        }
        assert resp == 'Hello from a Groovy Servlet!'
    }
    
    @Test
    void testHelloServletPostWithoutName() {
        def http = new HTTPBuilder("http://localhost:$httpPort/")
        def resp = http.post(path:'HelloServletWithHttpBuilder/hellogs',
            requestContentType: ContentType.TEXT) { resp, reader ->
            reader.text.trim()
        }
        assert resp == 'Hello, World!'
    }

    @Test
    void testHelloServletPostWithName() {
        def http = new HTTPBuilder("http://localhost:$httpPort/")
        def resp = http.post(path:'HelloServletWithHttpBuilder/hellogs',
            requestContentType: ContentType.TEXT,
            query:[name:'Dolly']) { resp, reader ->
            reader.text.trim()
        }
        assert resp == 'Hello, Dolly!'
    }
}
