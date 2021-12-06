package com.qa.test;

import org.testng.annotations.Test;

public class TestNGException {

	@Test(expectedExceptions = ArithmeticException.class)
	public void testException() {
		System.out.println("SoftwareTestingMaterial.com");
		int i = 1 / 0;
	}
}
