package io

println 'Please enter some numbers'
System.in.withReader { br ->
    println br.readLine().tokenize()*.toBigDecimal().sum()
}
