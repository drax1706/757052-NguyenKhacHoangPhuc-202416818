package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media a, Media b) {
        int costCompare = Float.compare(b.getCost(), a.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        return a.getTitle().compareToIgnoreCase(b.getTitle());
    }
}
