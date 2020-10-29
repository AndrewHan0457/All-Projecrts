package all_files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class COMP3053CheckerTest {

	public COMP3053Checker checker;
	public String test_Email;
	public String test_Pwd;
	
	@BeforeEach
	void setUp() throws Exception {
		test_Email = "woshifashi-117@163.com";
		test_Pwd = "Qingfeng123";
		checker = new COMP3053Checker(test_Email, test_Pwd);
	}

	//email part.
	@Test 
	void test1() {//the body below will show which method to be tested, no need to name as "testBeginWithAlphbat()"
		assertEquals(true, checker.beginWithAlphabet());
	}

	@Test
	void test2() {
		assertEquals(true, checker.separatedByAt());
	}
	
	@Test
	void test3() {
		assertEquals(true, checker.leftLength());
	}
	
	@Test
	void test4() {
		assertEquals(true, checker.rightLength());
	}
	
	@Test
	void test5() {
		assertEquals(true, checker.rightSeparatedByDot());
	}
	
	//pwd part.
	@Test
	void test6() {
		assertEquals(true, checker.containUppercaseLetters());
	}
	
	@Test
	void test7() {
		assertEquals(true, checker.containLowercaseLetters());
	}
	
	@Test
	void test8() {
		assertEquals(true, checker.containNums());
	}
	
	@Test
	void test9() {
		assertEquals(true, checker.beginWithNumOrSymbol());
	}
	
	@Test
	void test10() {
		assertEquals(true, checker.lengthAtLeast8());
	}
}
