package personalproject;

public class BanhMiCha extends BanhMi {

    int coupons;

    public BanhMiCha() {
    }

    public BanhMiCha(int coupons, String id, String breadFilling, int size) {
        super(id, breadFilling, size);
        this.coupons = coupons;
    }

    public int getCoupons() {
        return coupons;
    }

    public void setCoupons(int coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return super.toString()+coupons+"\t"+getPrice();
    }

    @Override
    public long getPrice() {
        return 8000*getSize();
    }
}
