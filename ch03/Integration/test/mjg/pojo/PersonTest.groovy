package mjg.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

class PersonTest {
    Person p
    
    @Test
    public void testPerson() {
        p = new Person()
        assertEquals 0, p.id
        assertNull p.name
    }

    @Test
    public void testPersonIntString() {
        p = new Person(1,'Buffy')
        assertEquals 1, p.id
        assertEquals "Buffy", p.name
    }

    @Test
    public void testGetId() {
        p = new Person(id:99)
        assertEquals 99, p.id
    }

    @Test
    public void testGetName() {
        p = new Person(id:86,name:'Maxwell Smart')
        assertEquals 86, p.id
        assertEquals 'Maxwell Smart', p.name
    }
}
