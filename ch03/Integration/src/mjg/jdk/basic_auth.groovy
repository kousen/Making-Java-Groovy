package mjg.jdk

def u = 'username'
def p = 'password'
def encoded = "$u:$p".getBytes().encodeBase64().toString()
println "$u:$p -> $encoded"
assert encoded == 'dXNlcm5hbWU6cGFzc3dvcmQ='
def (user,pass) = new String(encoded.decodeBase64()).split(':')
println "(user,pass) = ($user,$pass)"
assert user == u
assert pass == p
