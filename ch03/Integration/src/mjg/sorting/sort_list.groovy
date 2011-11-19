package mjg.sorting

import mjg.pojo.Person

def strings = ['here','are','a','few','strings']
assert strings.sort { it.size() } == ['a','are','few','here','strings']
assert strings.sort() == ['a','are','few','here','strings']

def peter = new Person(name:'Peter')
def lois = new Person(name:'Lois')
def chris = new Person(name:'Chris')
def meg = new Person(name:'Meg')
def stewie = new Person(name:'Stewie')
def people = [peter, lois, chris, meg, stewie]

assert people.sort { it.name } == [chris, lois, meg, peter, stewie]
assert people.sort { it.name.size() } == [meg, lois, chris, peter, stewie]
