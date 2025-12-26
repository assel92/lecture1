import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Item item [] = new Phone[3];
        item[0]= new Phone(2,300000,"Iphone11","IOS",256);
        item[1]= new Phone(3,300000,"Android","Android",256);
        item[2]= new Phone(4,300000,"IOS","IOS",256);
        item [0].setPrice(10000);
        Order order [] = new Order[1];
        order[0]=new Order("completed",0);
        if (order[0].getStatus().equals("completed")) {
            System.out.print("Enter new number of phones ");
            int newQuantity = scanner.nextInt();
            order[0].setQuantity(newQuantity);
            item[0].setQuantity(newQuantity);
            System.out.println("New number of phones " + item[0].getQuantity());
        } else {
            System.out.println("Order is not complete");
        }
    }

}