public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        itinerary.addLast("Ha Noi - Ho Guom");
        itinerary.addLast("Ha Long Bay");
        itinerary.addLast("Hue - Kinh Thanh");

        System.out.println("Initial Itinerary:");
        for (String stop : itinerary){
         System.out.println("- " + stop);
        }
        // Lưu vị trí Ha Long trước (quan trong)
        Position<String> hanoi = itinerary.first();
        Position<String> halong = itinerary.after(hanoi); // <= lấy trước khi thay đổi

        // add Sa Pa after Hà Nội
        itinerary.addAfter(hanoi, "Sa Pa");

        // Ninh binh are added  before halong , halong still point to Ha Long BayBây giờ chèn Ninh Binh trước Ha Long (halong vẫn trỏ tới "Ha Long Bay")
        itinerary.addBefore(halong, "Ninh Binh - Trang An");

        System.out.println("\nUpdated Itinerary:");
        for (String stop : itinerary){ System.out.println("- " + stop);}

// replace set
        itinerary.set(itinerary.last(), "Da Nang - Ba Na Hills");

        System.out.println("\nFinal Itinerary:");
        for (String stop : itinerary){ System.out.println("- " + stop);}
    }
}
