package mjg.ast

import static org.junit.Assert.*
import mjg.ast.delegate.Developer
import mjg.ast.delegate.LocalDeveloper
import mjg.ast.delegate.RemoteDeveloper

import org.junit.Before
import org.junit.Test

class RemoteDeveloperTest {
	RemoteDeveloper rd;

	@Before
	public void setUp() throws Exception {
		rd = new RemoteDeveloper(developer:new LocalDeveloper());
	}
    
    @Test
    void testInterfaceImplemented() {
        assertTrue rd instanceof Developer
    }

	@Test
	public void testWhereAreYou() {
		assertEquals "in my office (in another country)", rd.whereAreYou()
	}

	@Test
	public void testRunTests() {
		assertTrue rd.runTests()
	}
	
	@Test
	public void testFixBugs() {
		assertEquals 100, rd.fixBugs()
	}
	
	@Test
	public void testWriteCode() {
		assertEquals "lots of code", rd.writeCode()
	}
}
