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

def sdf = new SimpleDateFormat("MMM dd, yyyy")
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
