package hust.soict.dsai.aims.media;

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


    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
