package aims;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Russo", 87, 90.91f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spider-Man",
				"Science Fiction", "Tom Holland", 87, 100.23f);
		
//		ADD
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.addDigitalVideoDisc(dvd4);
//		anOrder.addDigitalVideoDisc(dvd5);
		System.out.println(anOrder.getQtyOrdered() + " item(s) in the cart.");
		System.out.println("Total cost is: " + anOrder.totalCost());
		
//		REMOVE
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.removeDigitalVideoDisc(dvd5);
		System.out.println(anOrder.getQtyOrdered() + " item(s) in the cart.");
		System.out.println("Total cost is: " + anOrder.totalCost());
	}

}