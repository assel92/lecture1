import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Inventory inventory = new Inventory();
        inventory.add(new Phone(2, 300000, "Iphone11", "iOS", 256));
        inventory.add(new Phone(3, 250000, "Samsung", "Android", 128));

        System.out.println("Search ID 2: " + inventory.searchById(2));
        System.out.println("Filter brand Samsung: " + inventory.filterByBrand("Samsung"));

        inventory.sortByPriceAscending();
        System.out.println("Sorted Ascending: " + inventory.getAll());

    }
}