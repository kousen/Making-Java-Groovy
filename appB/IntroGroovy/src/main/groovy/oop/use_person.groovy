package oop

Person mrIncredible = new Person()
mrIncredible.firstName = 'Robert'
mrIncredible.setLastName('Parr')
assert 'Robert Parr' == "${mrIncredible.firstName} ${mrIncredible.getLastName()}"
Person elastigirl = new Person(firstName: 'Helen', lastName: 'Parr')
assert 'Helen Parr' == elastigirl.toString()
