package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	/*
	 * @Test public void softAssert() { SoftAssert softAssertion = new SoftAssert();
	 * System.out.println("softAssert Method Was Started");
	 * softAssertion.assertTrue(false);
	 * System.out.println("softAssert Method Was Executed");
	 * softAssertion.assertAll();
	 * 
	 * }
	 * 
	 * @Test public void hardAssert() {
	 * System.out.println("hardAssert Method Was Started");
	 * Assert.assertTrue(false);
	 * System.out.println("hardAssert Method Was Executed"); }
	 */
	
	@Test
	public void hardAssert1() {
		System.out.println("assertTrue(true) Method Was Started");
		Assert.assertTrue(true);
		System.out.println("assertTrue(true) Method Was Executed");
	}
	
	@Test
	public void hardAssert2() {
		System.out.println("assertTrue(false) Method  Was Started");
		Assert.assertTrue(false);
		System.out.println("assertTrue(false) Method Was Executed");
	}
}
