package mjg

def ex = new Expando()
ex.name = 'Fido'
ex.speak = { "$name says Woof!" }
println ex
println ex.speak()