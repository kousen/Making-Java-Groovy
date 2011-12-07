package conditionals

def strings = ['how','are','you']
def results = []
strings.eachWithIndex { s,i -> results << "$i:$s" }
assert results == ["0:how","1:are","2:you"]
 
def words = "I'm a Groovy coder".tokenize()
def capitalized = ''
for (word in words) {
    capitalized += word.capitalize() + ' '
}
assert capitalized == "I'm A Groovy Coder "

// traditional Java for loop
for (int i = 0; i < words.size(); i++) {
	println "$i -- ${words[i]}"
}

// traditional Java while loop
int x = 1000
while (x > 1) {
	println x
	x = x/2
}