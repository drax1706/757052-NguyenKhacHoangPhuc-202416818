package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
public class DigitalVideoDisc extends Media implements Playable {

    private String director;
    private int length;


    public DigitalVideoDisc(String title) {
        super(title);
    }


    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost);
    }


    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, cost);
        this.director = director;
    }


    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    
    
    
    
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("DVD length is non-positive!");
            throw new PlayerException("DVD length is non-positive!");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    @Override
    public String toString() {
        return "DVD - " + getTitle()+ " - " + getCategory()+ " - " + getDirector()+ " - " + getLength()+ " : " + getCost() + " $";
    }

}
