package mjg.mvn

import static org.junit.Assert.*
import org.junit.Test

class HelloJavaTest {
    HelloJava hj = new HelloJava()
    
    @Test
    void testSayHello() {
        assert 'Hello, World!' == hj.sayHello('World')
    }
}