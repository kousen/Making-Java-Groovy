package closures

boolean isPrime1(int x) {
    if (x == 2) return true
    int limit = Math.sqrt(x) + 1
    (2..limit).each { n ->
        if (x % n == 0) return false
    }
    return true
}

assert (2..20).findAll { isPrime1(it)} == (2..20) // Wait, what??

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

assert (2..20).findAll { isPrime2(it)} == [2, 3, 5, 7, 11, 13, 17, 19] // works, but no break

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

assert (2..20).findAll { isPrime3(it) } == [2, 3, 5, 7, 11, 13, 17, 19] // works

Number.metaClass.isPrime = { ->
    Integer x = delegate as Integer
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

assert (2..20).findAll { it.isPrime() } == [2, 3, 5, 7, 11, 13, 17, 19]