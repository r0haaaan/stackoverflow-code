package in.rohaan;

public class Bird {
    private String birdName = "";
    private int birdCount = 0;
    
    
    public Bird(String s) {
        this.birdName = s;
        this.birdCount = 0;
    }
    
    public String getBirdName() {
        String s = birdName;
        return s;
    }
    
    public int getBirdCount() {
        int n = birdCount;
        return n;
    }
    
    public void addBirdCount() {
        int n = getBirdCount();
        n++;
        this.birdCount = n;
    }
    
       @Override
       public String toString() {
            return (""+this.getBirdName()+
                        " : "+ this.getBirdCount());
       }
}