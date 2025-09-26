import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scan = new Scanner(System.in);
       int choice;
// using do while compared to while (true) if for loop
// but do while if user take an input in text throws Exception 
        do {
            System.out.println("  Text Editor ");
            System.out.println("1. Add text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Print current text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
             choice = scan.nextInt();
            scan.nextLine(); // skip the new line after take an input number

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    String text = scan.nextLine();
                    editor.add(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.printCurrent();
                    break;
                case 5:
                    System.out.println("Exit Successfully!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 5);

        scan.close();
    }
}
