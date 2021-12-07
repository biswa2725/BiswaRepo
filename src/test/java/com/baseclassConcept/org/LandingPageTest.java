package com.baseclassConcept.org;

import com.baseclassConcept.org.*;

public class LandingPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instantiate LandingPage class object
		LandingPage landingPage = new LandingPage();

		// Verify the titles
		if (landingPage.getTitle().equals("My Store")) {
			System.out.println("Title Matched - Test Passes");
		} else {
			System.out.println("Title doesn't match - Test Failed");
		}

	}

}
