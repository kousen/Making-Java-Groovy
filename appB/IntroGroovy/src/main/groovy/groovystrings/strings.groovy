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
package groovystrings

def s = 'this is a string'
assert s.class == java.lang.String

def gs = "this might be a GString"
assert gs.class == java.lang.String
assert !(gs instanceof GString)

gs = "If I put in a placeholder, this really is a GString: ${1+1}"
assert gs instanceof GString

def ss = /This is a slashy string/
assert ss.class == java.lang.String

def picard = '''
	(to the tune of Let It Snow)
	Oh the vacuum outside is endless
	Unforgiving, cold, and friendless
	But still we must boldly go
	Make it so, make it so, make it so!
'''

String x = 'Hello'
String y = x << ', World!'
assert y == 'Hello, World!'

def palindromes = '''
	Madam, in Eden, I'm Adam
	Sex at noon taxes
	Flee to me, remote elf!
'''
palindromes.eachLine {
	String str = it.trim().replaceAll(/[ ,\'!?]/,'').toLowerCase()
	assert str.reverse() == str
}

def quote = """
	There are ${Integer.toBinaryString(2)} kinds of people in the world:
	Those who know binary, and those who don't
"""
assert quote == '''
	There are 10 kinds of people in the world:
	Those who know binary, and those who don't
'''