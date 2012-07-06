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
package regex

['bab','bcb','bdb'].each { assert it ==~ /b.b/ }
['bab','bcb','bdb'].each { assert it ==~ /b[acd]b/ }

['bbb','bcb','bdb'].each { assert it ==~ /b[^aeiou]b/ }

def pattern = /[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]/
(-10..<0).each { assert !(it ==~ pattern) }
(0..255).each { assert it ==~ pattern }
(256..300).each { assert !(it ==~ pattern) }


// yyyy-MM-dd, yyyy/MM/dd s.t.
//   yyyy is 19xx or 20xx
//   MM is 01..12
//   dd is 01..31
pattern = /(19|20)\d{2}[-\/](0[0-9]|1[0-2])[-\/](0[1-9]|[12]\d|3[01])/
def c = Calendar.instance
c.set(1899,10,30)
Date testStart = c.time
c.set(2100,1,1)
Date testEnd = c.time
c.set(1900,0,1)
Date rangeStart = c.time
c.set(2099,11,31)
Date rangeEnd = c.time
def sdf1 = new java.text.SimpleDateFormat("yyyy-MM-dd")
def sdf2 = new java.text.SimpleDateFormat("yyyy/MM/dd")
(testStart..testEnd).each { date ->
	if (date < rangeStart || date > rangeEnd) {
		assert !(sdf1.format(date) ==~ pattern)
		assert !(sdf2.format(date) ==~ pattern)
	} else {
		assert sdf1.format(date) ==~ pattern 
		assert sdf2.format(date) ==~ pattern
	}
}


def s = "now is is the the time"
def match = s =~ /\b(\w+)\s\1\b/
(0..<match.count).each { line -> println match[line][0] }
s = 'aba abc abba baab'
match = s =~ /\b(a)\w*\1\b/
(0..<match.count).each { line -> println match[line][0] }
