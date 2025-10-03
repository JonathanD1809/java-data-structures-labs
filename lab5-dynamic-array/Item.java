public class Item {
    private String name; // tên của item

    // Constructor 
    public Item(String name) {
        this.name = name;
    }

    // Getter 
    public String getName() {
        return name;
    }

    // to String
    @Override
    public String toString() {
        return name;
    }
}
