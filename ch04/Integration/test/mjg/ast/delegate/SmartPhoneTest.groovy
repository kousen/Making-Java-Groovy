package mjg.ast.delegate

import org.junit.Test;

class SmartPhoneTest {
	SmartPhone sp = new SmartPhone()
	
	@Test
	void testPhone() {
		assert 'dialing 555-1234' == sp.dial('555-1234')
	}
	
	@Test
	void testCamera() {
		assert 'taking picture' == sp.takePicture()
	}
}
