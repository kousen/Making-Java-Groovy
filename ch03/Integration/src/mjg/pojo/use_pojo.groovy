package mjg.pojo

def buffy = new Person(name:'Buffy')
assert buffy.id == 0
assert buffy.name == 'Buffy'

def faith = new Person(name:'Faith',id:1)
assert faith.id == 1
assert faith.name == 'Faith'

def willow = [name:'Willow',id:2] as Person
assert willow.id == 2
assert willow.name == 'Willow'

def slayers = [buffy, faith]
assert ['Buffy','Faith'] == slayers*.name
assert slayers.class == java.util.ArrayList

def characters = slayers + willow
assert ['Buffy','Faith','Willow'] == characters*.name
def doubles = characters.findAll { it.name =~ /([a-z])\1/ }
assert ['Buffy','Willow'] == doubles*.name