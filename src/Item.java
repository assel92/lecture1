public class Item {
    private int id;
    private static int id_gen=1;
    private String name;
    private int number;
    private double price;
    Item(){
        id=id_gen++;
    }
    Item(String name, int number, double price) {
        this();
        setName(name);
        setNumber(number);
        setPrice(price);
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
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
        return id + ": " + name + " " + number + "x " + price;
    }
}
