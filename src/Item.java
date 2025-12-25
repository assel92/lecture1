public class Item {
    private int id;
    private static int id_gen=1;
    private int number;
    private double price;
    public Item(){
        id=id_gen++;
    }
    public Item(int number, double price) {
        this();
        setNumber(number);
        setPrice(price);
    }
    public int getId() {
        return id;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public String toString() {
        return id + ": " + number + "x " + price;
    }
}
