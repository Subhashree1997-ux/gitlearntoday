package org.two;

import org.junit.Assert;
import org.junit.Test;

public class Assertions {
	@Test
	public void tc01() {
		String s="Java";
		System.out.println("Test1");
		boolean contains = s.contains("k");
		Assert.assertTrue(contains);
		System.out.println("\t"+contains);
	}
	@Test
	public void tc02() {
		String s="Selenium";
		System.out.println("Test2");
		boolean contains = s.contains("k");
		Assert.assertFalse(contains);
		System.out.println("\t"+contains);
	}
	@Test
	public void tc03()
	{
		String s="Ruby";
		System.out.println("Test3");
		boolean contains = s.contains("k");
		Assert.assertEquals(true,contains);
		System.out.println("\t"+contains);
		
	}
	@Test
	public void tc04() {
		String s="API";
		System.out.println("Test4");
		boolean contains = s.contains("k");
		Assert.assertNotEquals(true,contains);
		System.out.println("\t"+contains);
		System.out.println("changes made by QA");
		System.out.println("changes made by dev");
	}
}
