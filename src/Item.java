import java.util.Objects;
public abstract class Item {
    private int id;
    private static int id_gen = 1;
    private int number;
    private double price;

    public Item(int number, double price) {
        this.id = id_gen++;
        this.number = number;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " {id=" + id +
                ", number=" + number +
                ", price=" + price + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
