package Entites;

public class Phone extends Item {
    private String brand;
    private String OS;
    private int storage;
    private String color;

    public Phone(int id, int number, float price, String brand, String OS, int storage, String color) {
        super(id, number, price);
        this.brand = brand;
        this.OS = OS;
        this.storage = storage;
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color=color;
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
    @Override
    public String toString() { return id+" "+ number +" "+ price+ " " + brand + " " + OS + " " + "with "+ storage+ " GB" +" "+ color; }
}