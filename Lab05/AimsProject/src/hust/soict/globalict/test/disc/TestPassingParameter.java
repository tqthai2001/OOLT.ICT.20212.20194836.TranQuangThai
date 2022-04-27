package hust.soict.globalict.test.disc;

import java.time.LocalDate;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle DVD Title: " + jungleDVD.getTitle());
		System.out.println("Cinderella DVD Title " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("Jungle DVD Title " + jungleDVD.getTitle());
	}
	
//	public static void swap(Object o1, Object o2) {
//		Object tmpObject = o1;
//		o1 = o2;
//		o2 = tmpObject;
//	}
	
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String tmpTitle = dvd1.getTitle();
		String tmpCategory = dvd1.getCategory();
		String tmpDirector = dvd1.getDirector();
		int tmpLength = dvd1.getLength();
		float tmpCost = dvd1.getCost();
		int tmpID = dvd1.getId();
		LocalDate tmpDateAdded = dvd1.getDateAdded();
		
		dvd1.setTitle(dvd2.getTitle());
		dvd1.setCategory(dvd2.getCategory());
		dvd1.setDirector(dvd2.getDirector());
		dvd1.setLength(dvd2.getLength());
		dvd1.setCost(dvd2.getCost());
		dvd1.setId(dvd2.getId());
		dvd1.setDateAdded(dvd2.getDateAdded());
		
		dvd2.setTitle(tmpTitle);
		dvd2.setCategory(tmpCategory);
		dvd2.setDirector(tmpDirector);
		dvd2.setLength(tmpLength);
		dvd2.setCost(tmpCost);
		dvd2.setId(tmpID);
		dvd2.setDateAdded(tmpDateAdded);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}