package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book("Conan", "Manga", "Special drama for the live-action of Detective Conan", 25.75f);
		book1.addAuthor("Gosho");
		book1.addAuthor("Howard");
		
		Book book2 = new Book("Doraemon", "Comic", "I can can the can, but the can cannot can me", 56.78f);
		book2.addAuthor("Fujio");
		
		Book book3 = new Book("Elsa", "Comic", "East or West, home is best", 12.34f);
		book3.addAuthor("Robert");
		book3.addAuthor("Camp");
		book3.addAuthor("Carter");
		
		System.out.println(book2.toString());
		System.out.println("------------------------------");
		System.out.println(book3.toString());
	}

}
