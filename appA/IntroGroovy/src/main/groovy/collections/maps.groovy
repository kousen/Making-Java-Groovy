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
package collections

// Start with an empty map
def ALEast = [:]
assert ALEast instanceof HashMap

// Java put and get methods
ALEast.put('Boston','Red Sox')
assert 'Red Sox' == ALEast.get('Boston')
assert ALEast == [Boston:'Red Sox']

// Overridden putAt method
ALEast['New York'] = 'Yankees'

// Size method and dot access
assert 2 == ALEast.size()
assert 'Red Sox' == ALEast.Boston
assert 'Yankees' == ALEast.'New York'

assert ALEast == [Boston:'Red Sox','New York':'Yankees']
assert ALEast['Boston'] == 'Red Sox'

// Initialized map
Map<String,String> ALCentral = [Cleveland:'Indians',
   Chicago:'White Sox',Detroit:'Tigers']
assert 3 == ALCentral.size()
assert ALCentral.Cleveland == 'Indians'

// Overridden plus method
def both = ALEast + ALCentral
assert 5 == both.size()
assert both == [Boston:'Red Sox','New York':'Yankees',
	Cleveland:'Indians', Chicago:'White Sox',Detroit:'Tigers']

// keySet method
assert ALEast.keySet() == ['Boston','New York'] as Set

// Get method with a default
assert !ALEast.get('Toronto')
assert 'Blue Jays' == ALEast.get('Toronto','Blue Jays')
assert 'Blue Jays' == ALEast['Toronto']

def map = [x:1, y:2, z:3]

// each iterator
String keys1 = ''
List<Integer> values1 = []
both.each { key,val ->
	keys1 += '|' + key
	values1 << val
}

String keys2 = ''
List<Integer> values2 = []
both.each { entry ->
	keys2 += '|' + entry.key
	values2 << entry.value
}
assert keys1 == keys2
assert values1 == values2
