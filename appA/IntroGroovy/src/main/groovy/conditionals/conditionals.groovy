package conditionals

if (true) assert true

if (1)
	assert true
else
	assert false

def result = 5 > 3 ? 'x' : 'y'
assert result == 'x'

// name supplied as a parameter, or not

// result = name ? name : 'Elvis'
// like nvl(varname,literal) in SQL

def greet(name) { "${name ?: 'Elvis'} has left the building" }
assert greet() == 'Elvis has left the building'
assert greet(null) == 'Elvis has left the building'
assert greet('Priscilla') == 'Priscilla has left the building'

def hello(name = 'World') { "Hello, $name!" }
assert hello() == 'Hello, World!'
assert hello(null) == 'Hello, null!'
assert hello('Dolly') == 'Hello, Dolly!'

// 'reused' from Groovy In Action -- buy it!
switch (10) {
	case 0: 			assert false; break
	case 0..9: 			assert false; break
	case [8,9,11]: 		assert false; break
	case Float: 		assert false; break
	case { it%3 == 0 }: assert false; break
	case ~/../: 		assert true; break
	default: 			assert false
}

def val
def a, b, c
// long form (Java like)
if (a != null) {
	if (a.b != null) {
		val = a.b.c
	} else {
		val = null
	}
} else {
	val = null
}

// easier way (Groovy)
val = a?.b?.c
