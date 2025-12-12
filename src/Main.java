import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Item [] item = new Item[3];
        item[0] = new Item("Iphone 15", 1, 550000.05);
        item[1] = new Item("Iphone 16", 4, 650000.50);
        item[2] = new Item("Iphone 13", 10, 350000.05);
        Customer[]customer = new Customer[2];
        customer[0] = new Customer("Aiym", "Rakhmetova", "oemsps2020@mail.ru");
        customer[1] = new Customer("Ai Aru", "Rakhmetova", "aiarurahmet15@mail.ru");
        Order[] order = new Order[4];
        order[0] = new Order("issued",0);
        order[1] = new Order("in a way",3);
        order[2] = new Order("packed",7);
        order[3] = new Order("declined",0);
        System.out.println(item[0].toString());
        System.out.println(customer[0].toString());
        System.out.println(order[0].toString());
    }
}