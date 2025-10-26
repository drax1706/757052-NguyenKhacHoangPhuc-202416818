package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String directory;
	private int length;
	private float cost;
	private int id;
   
	
    private static int nbDigitalVideoDiscs = 0;
	
	
	public String getTitle() {
		return title;
	}
	public DigitalVideoDisc(String title) {
		this.title =title;
		nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.directory = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.directory = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    
	
	public String getCategory() {
		return category;
	}
	public String getDirectory() {
		return directory;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
        return id;
    }
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	
    public void setTitle(String title) {
    	this.title =title ; 
    }
    
    
    public String toString() {
    	return "DVD - " + title + " - " + category + " - " + directory + " - " + length + ": " + cost + " $";
    }
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
}
