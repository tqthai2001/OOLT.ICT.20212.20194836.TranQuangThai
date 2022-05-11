package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private String content;
	
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName))
			System.out.println("Author is already!");
		else {
			authors.add(authorName);
//			System.out.println("Add successfully.");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
//			System.out.println("Remove successfully.");
		}
		else System.out.println("Author is not in list!");
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String category, String content, float cost) {
		super(title, category, cost);
		this.content = content;
	}
	
	public Book copyData() {
		Book tmpBook = new Book(this.title, this.category, this.content, this.cost);
		tmpBook.setAuthors(this.getAuthors());
		tmpBook.setDateAdded(this.getDateAdded());
		tmpBook.setId(this.getId());
		return tmpBook;
	}
	
	public String toString() {
		return "Book - ID: " + this.id + " - " + this.title + " - " + this.category + " - " + this.authors
				+ " - " + this.content + ": " + this.cost + " $";
	}
	
	public void seeDetail() {
		Map<String, Integer> freqMap = new HashMap<>();
		String[] word = content.toLowerCase().split("[, ?.@-]+");
		for (int i = 0; i < word.length; i++) {
			if (freqMap.containsKey(word[i])) {
				freqMap.put(word[i], freqMap.get(word[i]) + 1);
			}
			else {
				freqMap.put(word[i], 1);
			}
		}
//		Sort token list
		ArrayList<String> sortedKeys = new ArrayList<String>(freqMap.keySet());
		Collections.sort(sortedKeys);
		
		System.out.println("Book - ID: " + this.id + " - " + this.title + " - " + this.category + " - "
			+ this.authors + " - " + "Content Length: " + freqMap.size() + " - " + "Cost: " + this.cost + " $");
		System.out.print("Token: ");
		for (String key : sortedKeys) {
			System.out.print(key + "\t");
		}
		System.out.println("");
		System.out.print("Freq:  ");
		for (String key : sortedKeys) {
			System.out.print(freqMap.get(key) + "\t");
		}
		System.out.println("");
	}

}