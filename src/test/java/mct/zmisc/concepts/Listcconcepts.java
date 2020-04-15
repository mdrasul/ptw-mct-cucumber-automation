package mct.zmisc.concepts;

import java.util.ArrayList;
import java.util.List;

public class Listcconcepts {

	
	public static void main(String[] args) {
		
		
		
		// List 
		// List is a API in Java that ususally called 
		// Collections API 
		
		List<String> mylist = new ArrayList<String>();
		
		mylist.add("Apple");
		mylist.add("orange");
		mylist.add("cucumber");
		
		System.out.println(mylist.size());
		
		
		mylist.remove(2);
		
		System.out.println(mylist.size());
		
		for(int i=0;i<mylist.size();i++) {
			System.out.println(mylist.get(i));
		}

	}
	
}
