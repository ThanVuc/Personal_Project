package personalproject;

public class BanhMiThit extends BanhMi{
    String drink;

    public BanhMiThit() {
    }

    public BanhMiThit(String drink, String id, String breadFilling, int size) {
        super(id, breadFilling, size);
        this.drink = drink;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return super.toString()+"\t"+drink+"\t"+getPrice();
    }

    @Override
    public long getPrice() {
        return getSize()*10000;
    }  
}
