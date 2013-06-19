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

import org.junit.Test;

public class GreetingTest {
    private Greeting greeting = new Greeting();
    
    @Test
    public void testGetMessage() {
        assertEquals("Hello, World!", greeting.getMessage());
    }

    @Test
    public void testSetMessage() {
        greeting.setMessage("What up?");
        assertEquals("What up?", greeting.getMessage());
    }

}
