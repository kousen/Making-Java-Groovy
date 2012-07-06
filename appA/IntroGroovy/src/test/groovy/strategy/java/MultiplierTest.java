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
package strategy.java;

import strategy.java.AddStrategy;
import strategy.java.Multiplier;
import strategy.java.TimesStrategy;
import junit.framework.TestCase;

public class MultiplierTest extends TestCase {

	private Multiplier m;
	
	@Override
	protected void setUp() throws Exception {
		m = new Multiplier();
	}
	
	public void testAddMultiplier() {
		m.setStrategy(new AddStrategy());
		assertEquals(6, m.multiply(2, 3));
	}
	
	public void testTimesMultiplier() {
		m.setStrategy(new TimesStrategy());
		assertEquals(6, m.multiply(2, 3));
	}

}
