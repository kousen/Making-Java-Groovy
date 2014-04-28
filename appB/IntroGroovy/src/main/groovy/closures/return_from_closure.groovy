package closures

boolean checkImplementation(Closure c) {
    (2..20).findAll { c(it) } == [2, 3, 5, 7, 11, 13, 17, 19]
}

// THIS DOESN'T WORK
boolean isPrime1(int x) {
    if (x == 2) return true
    int limit = Math.sqrt(x) + 1
    (2..limit).each { n ->
        // nice try, but a return in a closure
        // returns only from the closure
        if (x % n == 0) return false
    }
    return true
}

assert !checkImplementation(this.&isPrime1) // See?

// can set a variable, but can't break out of the loop
boolean isPrime2(int x) {
    if (x == 2) return true
    boolean result = true
    int limit = Math.sqrt(x) + 1
    (2..limit).each { n ->
        if (x % n == 0) {
            result = false
            // don't you wish you could break here?
        }
    }
    return result
}

assert checkImplementation(this.&isPrime2)

// use for-in loop instead, and it works
boolean isPrime3(int x) {
    if (x == 2) return true
    boolean result = true
    int limit = Math.sqrt(x) + 1
    for (n in 2..limit) {
        if (x % n == 0) {
            result = false
            break
        }
    }
    return result
}

assert checkImplementation(this.&isPrime3)

// of course, if you use for-in, you can use return
boolean isPrime4(int x) {
    if (x == 2) return true
    int limit = Math.sqrt(x) + 1
    for (n in 2..limit) {
        if (x % n == 0) return false
    }
    return true
}

assert checkImplementation(this.&isPrime4)

// don't forget about the find method, though
// (Elegant implementation courtesy of Tim Yates, @tim_yates)
boolean isPrime5(int x) {
    int limit = Math.sqrt(x) + 1
    x == 2 || !(2..limit).find { n -> x % n == 0 }
}

assert checkImplementation(this.&isPrime5)

Number.metaClass.isPrime = { ->
    Integer x = delegate as Integer
    int limit = Math.sqrt(x) + 1
    x == 2 || !(2..limit).find { n -> x % n == 0 }
}

assert (2..20).findAll { it.isPrime() } == [2, 3, 5, 7, 11, 13, 17, 19]