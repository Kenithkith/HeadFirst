package org.cadenhead.ecommerce;

public class GiftShop {
	public static void main(String[] args) {

		StoreFront store = new StoreFront();
		store.addItem("C01", "Mug", "9.99", "150");
		store.addItem("C02", "Large Mug", "12.99", "82");
		store.addItem("C03", "Mousepad", "10.49", "800");
		store.addItem("D01", "T-shirt", "16.99", "90");

		store.sort();

		for (int i = 0; i < store.getSize(); i++) {
			ChapterSixItem show = (ChapterSixItem) store.getChapterSixItem(i);

			System.out.println("\nItem ID: " + show.getId() + "\nName: "
					+ show.getName() + "\nRetail Price: $" + show.getRetail()
					+ "\nWholesale Price: $" + show.getPrice() + "\nQuantity: "
					+ show.getQuantity());

		}
	}

}
