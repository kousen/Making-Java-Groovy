package intro

assert(1 + 2 == 3)
assert(3 - 2 == 1)
assert 4 * 5 == 20
assert 10/2 == 5
assert 10/4 == 2.5
assert 2**3 == 8
assert 2**-2 == 0.25 // i.e., 1/(2*2) = 1/4

assert 3 == 1.plus(2)
assert 1 == 3.minus(2)
assert 20 == 4.multiply(5)
assert 5 == 10.div(2)
assert 1 == 10.mod(3)

assert 5 > 3
assert 4 >= 4
assert 3 < 5
assert 3 <= 6
assert 7 == 7
assert 7 != 8

def i = 1
assert 1 == i++
assert 3 == ++i

def x = ""
// x += "Hello" same as x = x + "Hello"
3.times { x += "Hello" }
assert x == "HelloHelloHello"

3.times({x += "Hello"})
3.times() { x += "Hello" }

def total = 0
1.upto(3) { total += it }
assert total == 1 + 2 + 3

def countDown = []
5.downto 1, { countDown << "$it ..." }
assert countDown == ['5 ...', '4 ...', '3 ...', '2 ...', '1 ...']

def odds = []
(1..10).step(2) { odds << it }
assert odds == [1, 3, 5, 7, 9]
