package metaprogramming

Expando ex = new Expando()
ex.name = 'Fido'
ex.speak = { println "$name says Woof!" }
ex.speak()

class Cat {}
Cat.metaClass.name = 'Garfield'
Cat.metaClass.says = 'wants lasagna'
Cat.metaClass.speak { println "$name $says" }
Cat c = new Cat()
c.speak()

c.name = 'Fluffy'
c.says = 'meow'
c.speak()