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

def teams = ["Red Sox","Yankees"]
assert teams.class == java.util.ArrayList

def names = teams as String[]
assert names.class == String[]
def set = teams as Set
assert(set instanceof Set)

def strings = ['hello','world','how','are','you','hello']
assert strings.size() == 6
def stringSet = strings as Set
println stringSet
println strings[-1..-3]
println strings[-3..-1]
println strings[1,3,5]


teams << "Orioles"
assert teams == ["Red Sox","Yankees","Orioles"]
teams << ["Rays","Blue Jays"]
assert teams == ["Red Sox","Yankees","Orioles",["Rays","Blue Jays"]]
assert teams.flatten() == ["Red Sox","Yankees","Orioles","Rays","Blue Jays"]
assert teams + "Angels" - "Orioles" == 
	["Red Sox", "Yankees", ["Rays", "Blue Jays"], "Angels"]

assert teams[0] == 'Red Sox'
assert teams[1] == 'Yankees'
assert teams[-1] == ['Rays','Blue Jays']

teams = ["Red Sox","Yankees","Rays"]
def popped = teams.pop()
assert popped == "Rays"

assert ["Yankees","Mets"].reverse() == ["Mets","Yankees"]

def ALCentral = ["Indians","Tigers"]
assert ['Blue Jays','Indians','Mets'].intersect(ALCentral) == ["Indians"]

def cities = ["New York","Boston","Cleveland","Seattle"]
assert ['Boston','Cleveland'] == cities[1..2]
// Reversed
cities = cities.reverse()
assert cities == ["Seattle", "Cleveland", "Boston", "New York"]

// Natural ordering
cities = cities.sort()
assert cities == ["Boston", "Cleveland", "New York", "Seattle"]
cities = cities.sort { it.size() }
cities == ['Boston', 'Seattle', 'New York', 'Cleveland']

// Order by length of city name
cities = cities.sort { a,b -> a.size() <=> b.size() }
assert cities == ["Boston", "Seattle", "New York", "Cleveland"]
assert cities*.substring(0,3) == ["Bos","Sea","New","Cle"]
assert cities.collect { it.substring(0,3) } == ["Bos","Sea","New","Cle"]

// Collect applies closure to each element
def abbrev = cities.collect { city -> city[0..2].toLowerCase() }
assert abbrev == ["bos", "sea", "new", "cle"]

assert cities.collect { it.size() } == [6, 7, 8, 9]

//inject accumulates
int total = cities.inject(0) { nameLength, city ->
	nameLength += city.size()
}
assert 30 == total

assert ['a','b','c'].join('&') == 'a&b&c'

// any and every
assert cities.any { it.size() < 7 }
assert cities.every { it.size() < 10 }

assert 'New Hampshire' == 
	['New Hampshire','New Jersey','New York'].find { it =~ /New/ }

//findAll returns cities satisfying closure
def withE = cities.findAll { city -> city =~ /e/ }
assert withE == ["Seattle", "New York", "Cleveland"]

// join concatenates entries
assert cities.join(',') == "Boston,Seattle,New York,Cleveland"

