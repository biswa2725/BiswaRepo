package com.tsetng.param.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name="searchText")
	  public static Object[][] getDataProviderData(){
            	Object[][] searchWords=new Object[3][2];
            	//Enter data into Object Array
            	searchWords[0][0]="India Gate";
            	searchWords[0][1]="Delhi";
            	searchWords[1][0]="Taj Mahal";
            	searchWords[1][1]="Agra";
            	searchWords[2][0]="Char Minar";
            	searchWords[2][1]="Hyderabad";
      	  return searchWords;
        	  }
}