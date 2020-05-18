package µ¥Ôª²âÊÔ;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class unit_test {
	Calculate calculation ;
	@Before
	public void setUp()
	{
		calculation = new Calculate();
	}
	@Test
	public void test1()
	{
		int sum = calculation.sum(2, 5);
		int expected = 7;
		System.out.println("@Test sum(): " + sum + " = " + sum);
		assertEquals(sum, expected);
		assertEquals(8, calculation.sum(3, 5));
	}
	
	@Test
	public void test2()
	{
		assertEquals(8, calculation.sum(1 , 5));
	}
}
