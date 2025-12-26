public class Tablet extends Item {
    private String brand;
    private String OS;
    private int storage;

    public Tablet(int number, double price, String brand, String OS, int storage) {
        super(number, price);
        setBrand(brand);
        setOS(OS);
        setStorage(storage);
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getOS() {
        return OS;
    }
    public void setOS(String OS) {
        this.OS = OS;
    }
    public int getStorage() {
        return storage;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }
}
