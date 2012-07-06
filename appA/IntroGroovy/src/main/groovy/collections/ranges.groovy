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

import java.text.SimpleDateFormat

Range bothEnds = 5..8
assert bothEnds.contains(5)
assert bothEnds.contains(8)
assert bothEnds.from == 5
// equivalent to bothEnds.getFrom()
assert bothEnds.to == 8
assert bothEnds == [5, 6, 7, 8]

Range noUpper = 5..<8
assert noUpper.contains(5)
assert !noUpper.contains(8)
assert noUpper.from == 5
assert noUpper.to == 7
assert noUpper == [5, 6, 7]
assert "Range: $noUpper: from ${noUpper.from} to ${noUpper.to}" ==
'Range: [5, 6, 7]: from 5 to 7'

assert 1..5 == [1, 2, 3, 4, 5]
assert 'A'..'E' == ["A", "B", "C", "D", "E"]

def total = ('A'..'Z') + ('a'..'z') + (0..9)
println total
println total.class.name
[5,10,15,20].each { println "$it: ${total[it]}" }

def sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.US)
def cal = Calendar.instance
cal.set(2011,Calendar.FEBRUARY,27)
def now = cal.time
cal.set(2011,Calendar.MARCH,2)
def then = cal.time

def days = []
(now..then).each { day ->
    days << sdf.format(day)
}
assert days == [
    'Feb 27, 2011',
    'Feb 28, 2011',
    'Mar 01, 2011',
    'Mar 02, 2011'
]
