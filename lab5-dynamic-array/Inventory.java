import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items; // list of items from player

    public Inventory() {
        this.items = new ArrayList<>();
    }

    // add items in the inventory
    public void addItem(Item item) {
        items.add(item);
    }

    // display
    public void display() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Now, Inventory items:");
            for (Item item : items) {// use each loop to traverse
                System.out.println("- " + item);
            }
        }
    }

    // combine between 2 items into new item
    public void combineItems(String name1, String name2) {
        boolean found1 = false; // đã tìm thấy item1 chưa
        boolean found2 = false; // đã tìm thấy item2 chưa

        // Dùng iterator để duyệt và xóa an toàn
        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();

            // Nếu trùng tên name1 thì xóa và đánh dấu found1
            if (current.getName().equalsIgnoreCase(name1) && !found1) {// using equals(name1)
                iter.remove(); 
                found1 = true; 
            }
            //if equal so remove and then marked found 2
            else if (current.getName().equalsIgnoreCase(name2) && !found2) {
                iter.remove(); 
                found2 = true; 
            }
        }

        // after traversing .
        if (found1 && found2) {
            // if 2 items are founded  ,add new item item.c
            Item combined = new Item("Magic Staff"); 
            items.add(combined);
            System.out.println(" Combined Successfully! " + name1 + " and " + name2 + " into " + combined.getName() + "!");
        } else {
            System.out.println("Fortunately, failed to combine. Please check again you have both: " + name1 + " and " + name2 + ".");
        }
    }
}
