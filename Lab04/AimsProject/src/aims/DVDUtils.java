package aims;

public class DVDUtils {
	public static int compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (dvd1.getCost() > dvd2.getCost()) return 1;
		else if (dvd1.getCost() == dvd2.getCost()) return 0;
		else return -1;
	}
	
	public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.getTitle().compareToIgnoreCase(dvd2.getTitle());
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc [] dvdlist) {
		for (int i = 0; i < dvdlist.length - 1; i++) {
			for (int j = 0; j < dvdlist.length - i - 1; j++) {
				if (compareByCost(dvdlist[j], dvdlist[j+1]) < 0) {
					TestPassingParameter.swap(dvdlist[j], dvdlist[j+1]);
				}
			}
		}
		return dvdlist;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc [] dvdlist) {
		for (int i = 0; i < dvdlist.length - 1; i++) {
			for (int j = 0; j < dvdlist.length - i - 1; j++) {
				if (compareByTitle(dvdlist[j], dvdlist[j+1]) < 0) {
					TestPassingParameter.swap(dvdlist[j], dvdlist[j+1]);
				}
			}
		}
		return dvdlist;		
	}
}