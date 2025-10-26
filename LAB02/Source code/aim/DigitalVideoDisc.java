package aim;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String directory;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public DigitalVideoDisc(String title) {
		this.title =title;
	}
	public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.directory = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.directory = director;
        this.length = length;
        this.cost = cost;
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
	
    public void setTitle(String title) {
    	this.title =title ; 
    }
	
}
 