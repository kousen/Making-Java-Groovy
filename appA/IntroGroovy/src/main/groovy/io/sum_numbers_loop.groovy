package io

println 'Sum numbers with looping'
System.in.eachLine { line -> 
    if (!line) System.exit(0)
    println line.split(' ')*.toBigDecimal().sum()
}

