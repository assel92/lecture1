import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class Inventory {
        private List<Item> items = new ArrayList<>();

        public void add(Item item) {
            items.add(item);
        }

        public List<Item> getAll() {
            return items;
        }

        public Item searchById(int id) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getId() == id) {
                    return items.get(i);
                }
            }
            return null;
        }

        public List<Item> filterByBrand(String brand) {
            List<Item> result = new ArrayList<>();
            for (Item item : items) {
                if (item instanceof Phone) {
                    Phone phone = (Phone) item;
                    if (phone.getBrand().equalsIgnoreCase(brand)) {
                        result.add(phone);
                    }
                }
            }
            return result;
        }

        public void sortByPriceAscending() {
            for (int i = 0; i < items.size() - 1; i++) {
                for (int j = i + 1; j < items.size(); j++) {
                    if (items.get(i).getPrice() > items.get(j).getPrice()) {
                        Item temp = items.get(i);
                        items.set(i, items.get(j));
                        items.set(j, temp);
                    }
                }
            }
        }

        public void sortByPriceDescending() {
            sortByPriceAscending();
            Collections.reverse(items);
        }
    }
