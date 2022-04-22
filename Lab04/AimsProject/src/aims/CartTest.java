package aims;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spider-Man",
				"Science Fiction", "Tom Holland", 87, 100.23f);
//		**********************************************************
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Russo", 100, 90.91f);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Holland", 87, 93.96f);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Avengers",
				"Science Fiction", "Cruise", 99, 93.96f);
//		**********************************************************
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Batman",
				"Science Fiction", "Joe", 70, 86.90f);
		
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Captain America",
				"Science Fiction", "Lucas", 79, 88.22f);
		
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Batman",
				"Science Fiction", "Joe", 70, 86.90f);
		
		DigitalVideoDisc[] dvdlist = new DigitalVideoDisc[] {dvd10, dvd9, dvd8};
		
//		ADD
		System.out.println("__________ADD__________");
		cart.addDigitalVideoDisc(dvd1);
		cart.addDigitalVideoDisc(dvd2);
		cart.addDigitalVideoDisc(dvd3);
		cart.addDigitalVideoDisc(dvd4, dvd5); // Add 2 elements
		cart.addDigitalVideoDisc(dvd6, dvd7);
		cart.addDigitalVideoDisc(dvdlist); // Add many elements dvd8, dvd9, dvd10
		
//		REMOVE
		System.out.println("");
		System.out.println("__________REMOVE__________");
		cart.removeDigitalVideoDisc(dvd10);
		cart.removeDigitalVideoDisc(dvd1);
		System.out.println("");
		
//		SORT
		System.out.println("");
		System.out.println("__________SORT BY COST__________");
		cart.sortCartByCost();
		
		System.out.println("");
		System.out.println("__________SORT BY TITLE__________");
		cart.sortCartByTitle();
		
//		SEARCH
		System.out.println("");
		System.out.println("__________SEARCH__________");
		cart.searchByID(7);
		cart.searchByID(18);
		
//		PRINT CART
		System.out.println("");
		cart.printCart();
	}

}