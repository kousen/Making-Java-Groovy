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
package mjg.ast

import static org.junit.Assert.*
import mjg.ast.delegate.Developer
import mjg.ast.delegate.LocalDeveloper
import mjg.ast.delegate.RemoteDeveloper

import org.junit.Before
import org.junit.Test

class RemoteDeveloperTest {
	RemoteDeveloper rd;

	@Before
	public void setUp() throws Exception {
		rd = new RemoteDeveloper(developer:new LocalDeveloper());
	}
    
    @Test
    void testInterfaceImplemented() {
        assertTrue rd instanceof Developer
    }

	@Test
	public void testWhereAreYou() {
		assertEquals "in my office (in another country)", rd.whereAreYou()
	}

	@Test
	public void testRunTests() {
		assertTrue rd.runTests()
	}
	
	@Test
	public void testFixBugs() {
		assertEquals 100, rd.fixBugs()
	}
	
	@Test
	public void testWriteCode() {
		assertEquals "lots of code", rd.writeCode()
	}
}
