package org.cadenhead.ecommerce;

import java.util.*;

public class StoreFront {

	private LinkedList catalogue = new LinkedList();
	
	public void addItem(String id, String name, String price, String quant) {
		ChapterSixItem it = new ChapterSixItem(id, name, price, quant);
		catalogue.add(it);
		
	}
	
	public ChapterSixItem getChapterSixItem(int i) {
		return (ChapterSixItem)catalogue.get(i);
		
	}
	
	public int getSize() {
		return catalogue.size();
		
	}
	
	public void sort() {
		Collections.sort(catalogue);
		
	}
}
