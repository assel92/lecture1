 public class Phone extends Item {
    private Phone[] phones;
    private String brand;
    private String OS;
    private int storage;

    public Phone(int number, double price, String brand, String OS, int storage) {
        super(number, price);
        this.brand = brand;
        this.OS = OS;
        this.storage = storage;

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
