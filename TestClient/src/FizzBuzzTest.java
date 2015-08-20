import static org.junit.Assert.*;
import org.junit.Test;


public class FizzBuzzTest {

	@Test
	/*
	 * Test case with empty range
	 */
	public void testFizz_buzz() {
		assertTrue(FizzBuzz.fizz_buzz(1,1).length == 0);
	}
	
	@Test
	/**
	 * Test case with valid range
	 */
	public void testFizz_buzz_1() {
		
		assertArrayEquals(FizzBuzz.fizz_buzz(1, 3),new String[]{"1", "2"});
	}
	@Test
	/*
	 * Test case with random range
	 */
	public void testFizz_buzz_2() {
		assertArrayEquals(FizzBuzz.fizz_buzz(10, 16),new String[]{"Buzz", "11", "Fizz", "13","14", "FizzBuzz"});
	}
	
	@Test
	/**
	 * Test case where lower end is greater than higher
	 */
	public void testFizz_buzz_3() {
		
		assertArrayEquals(FizzBuzz.fizz_buzz(3, 1),new String[]{"1", "2"});
	}
	@Test(expected = ArithmeticException.class)
	/*
	 * Test case with negative range
	 */
	public void testFizz_buzz_4() {
		FizzBuzz.fizz_buzz(-1,1);
	}

}
