/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
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