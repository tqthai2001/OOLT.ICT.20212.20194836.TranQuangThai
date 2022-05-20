package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private String content;
	List<String> contentTokens = new ArrayList<String>();
	Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName))
			System.out.println("Author: " + authorName + " is already in list!");
		else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		}
		else System.out.println("Author: " + authorName + " is not in list!");
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String category, String content, float cost) {
		super(title, category, cost);
		this.content = content;
		processContent();
	}
	public Book(int id, String title, String category, float cost, LocalDate dateAdded, List<String> authors, String content) {
		super(id, title, category, cost, dateAdded);
		this.authors = authors;
		this.content = content;
		processContent();
	}
	
	public Book copyData() {
		Book tmpBook = new Book(this.id, this.title, this.category, 0f, this.dateAdded, this.authors, this.content);
		return tmpBook;
	}
	
	public void processContent() {
		String[] tokenList = content.toLowerCase().split("[, ?.@-]+");
		for (int i = 0; i < tokenList.length; i++) {
			contentTokens.add(tokenList[i]);
		}
		Collections.sort(contentTokens);
		for (String token : contentTokens) {
			if (wordFrequency.containsKey(token)) {
				wordFrequency.put(token, wordFrequency.get(token) + 1);
			}
			else wordFrequency.put(token, 1);
		}
	}
	
	public String toString() {
		String bookDetail = "Book - ID: " + this.id + " - " + this.title + " - " + this.category + " - "
				+ this.authors + " - " + "Content Length: " + wordFrequency.size() + " - "
				+ "Cost: " + this.cost + " $";
		String bookFreq = "\nToken list & Word frequency:\n";
		for (String token : wordFrequency.keySet()) {
			bookFreq += (token + "\t");
		}
		bookFreq += "\n";
		for (String token : wordFrequency.keySet()) {
			bookFreq += (wordFrequency.get(token) + "\t");
		}
		bookDetail += bookFreq;
		return bookDetail;
	}
	
	public void seeDetail() {
		String bookDetail = "Book - ID: " + this.id + " - " + this.title + " - " + this.category + " - "
				+ this.authors + " - " + "Content Length: " + wordFrequency.size() + " - "
				+ "Cost: " + this.cost + " $";
		String bookFreq = "\nToken list & Word frequency:\n";
		for (String token : wordFrequency.keySet()) {
			bookFreq += (token + "\t");
		}
		bookFreq += "\n";
		for (String token : wordFrequency.keySet()) {
			bookFreq += (wordFrequency.get(token) + "\t");
		}
		bookDetail += bookFreq;
		System.out.println(bookDetail);
	}

}