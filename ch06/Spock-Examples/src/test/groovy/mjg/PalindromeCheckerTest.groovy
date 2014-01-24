package mjg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class PalindromeCheckerTest {
	PalindromeChecker checker = new PalindromeChecker()

//	@Before
//	public void setUp() throws Exception {
//		checker = new PalindromeChecker()
//	}

	@Test(expected=IllegalArgumentException)
	void testThrowsException() {
		throw new IllegalArgumentException()
	}
	
	@Test
	public void testIsPalindrome() {
		assert checker.isPalindrome("Flee to me, remote elf!")
	}

}
