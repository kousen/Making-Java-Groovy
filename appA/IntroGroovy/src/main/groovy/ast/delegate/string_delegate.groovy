package ast.delegate

class WrappedString {
    @Delegate String string
}

WrappedString s = new WrappedString(string:'hello')
println s.metaClass.methods.name
try {
    println s.size()
} catch (MissingMethodException e) {
    System.err.println e
}
assert s.length() == 5
def str = "hello"
assert !("hello".metaClass.methods.name.findAll { it =~ /size/ })
assert str.size() == 5
