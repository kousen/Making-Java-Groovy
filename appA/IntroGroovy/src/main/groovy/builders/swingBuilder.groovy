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
package builders

import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import javax.swing.WindowConstants as WC

def builder = new SwingBuilder()
def frame = builder.frame(title:'Hello, Groovy!',
		size:[200,100],	defaultCloseOperation:WC.EXIT_ON_CLOSE) {
	panel(layout:new BL()) {
		def txt = textField(constraints:BL.NORTH,'Enter text here')
		def lab = label(constraints:BL.CENTER,'Text')
		button(constraints: BL.SOUTH, 'Move Text',
			actionPerformed: { lab.text = txt.text })
		txt.actionPerformed = { lab.text = txt.text }
	}
}
frame.visible = true
