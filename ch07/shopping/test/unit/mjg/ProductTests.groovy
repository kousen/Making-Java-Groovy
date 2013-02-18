package mjg

<<<<<<< HEAD


import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductTests {

    void testSomething() {
       fail "Implement me"
=======
import grails.test.mixin.*
import org.junit.*

@TestFor(Product)
class ProductTests {
    Product p = new Product(name: 'p0', price: 1)

    @Before
    void setUp() {
        mockForConstraintsTests(Product)
    }

    void testValid() {
       assert p.validate()
    }

    void testBlankName() {
        p.name = ' '
        assert !p.validate()
        assert 'blank' == p.errors.name
    }

    void testNegativePrice() {
        p.price = -1
        assert !p.validate()
        assert 'min' == p.errors.price
>>>>>>> rest
    }
}
