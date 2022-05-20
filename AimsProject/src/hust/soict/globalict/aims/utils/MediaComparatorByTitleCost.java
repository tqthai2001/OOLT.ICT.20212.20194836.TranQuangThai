package hust.soict.globalict.aims.utils;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	
	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		return Comparator.comparing(Media::getTitle)
						.reversed()
						.thenComparing(Media::getCost)
						.reversed()
						.compare(o1, o2);
	}
	
}
