public class Main {
    public static void main(String[] args) {
        Inventory magic = new Inventory();

        // add items at the beginning
        magic.addItem(new Item("Stick"));
        magic.addItem(new Item("Gem"));
        magic.addItem(new Item("Stone"));

        System.out.println("Before combining:");
        magic.display(); // display inventory

        // Thử combine 
        System.out.println("\nCombining Stick and Gem!");
        magic.combineItems("stick", "gem");

        System.out.println("\nAfter combining:");
        magic.display(); // hiển thị inventory sau khi kết hợp

        // Thử combine Stone + Gem (Gem đã bị xóa nên fail)
        System.out.println("\nCombining Stick and Gem...");
        magic.combineItems("Stone ", "Gem");

        System.out.println("\nFinal inventory:");
        magic.display();
    }
}
