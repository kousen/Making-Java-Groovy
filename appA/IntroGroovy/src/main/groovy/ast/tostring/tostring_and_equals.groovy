package ast.tostring

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

@EqualsAndHashCode
@ToString
class Product {
    int id
    String name
    def price
}

Product p_orig = new Product(id:1,name:'name',price:9.99)
Product p_copy = new Product(id:1,name:'name',price:9.99)
Product p_diff = new Product(id:2,name:'other',price:5)

assert p_orig == p_copy
assert !p_orig.is(p_copy)
assert p_orig != p_diff
assert p_orig.toString() == 'ast.tostring.Product(1, name, 9.99)'

Set<Product> products = [p_orig, p_copy, p_diff] as Set
assert products.size() == 2