package aims;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc: " + disc.getTitle() + " has been added.");
		}
		else {
			System.out.println("The cart is almost full.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int pos = -1;
		if (qtyOrdered <= 0) System.out.println("Cart is empty.");
		else {
			for (int i = 0; i < qtyOrdered; i++) {
				if (itemsOrdered[i] == disc) {
					pos = i;
				}
			}
			if (pos < 0 || pos > qtyOrdered) {
				System.out.println("The disc: " + disc.getTitle() + " is not in the cart.");
			}
			else {
				for (int j = pos; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyOrdered -= 1;
				System.out.println("The disc: " + disc.getTitle() + " has been removed.");
			}
		}
	}
	
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
}