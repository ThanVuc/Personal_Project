package personalproject;

public abstract class BanhMi implements IBanhMi{
    private String id, breadFilling;
    private int size;

    public BanhMi() {
    }

    public BanhMi(String id, String breadFilling, int size) {
        this.id = id;
        this.breadFilling = breadFilling;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBreadFilling() {
        return breadFilling;
    }

    public void setBreadFilling(String breadFilling) {
        this.breadFilling = breadFilling;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return id+"\t"+size+"\t"+breadFilling;
    }

    @Override
    public abstract long getPrice(); 
    
    
    
}
