package mjg

Map.metaClass.toQueryString = {
    delegate.collect { it }.join('&')
}

def map = [a:1, b:2, c:3]
assert 'a=1&b=2&c=3' == map.toQueryString()