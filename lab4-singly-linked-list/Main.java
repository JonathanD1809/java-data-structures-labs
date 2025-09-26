
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scan = new Scanner(System.in);

        while (true) { // using while to ask infinite
            System.out.println(" Jonathan's music menu:");
            System.out.println("1. Add song");
            System.out.println("2. Remove song");
            System.out.println("3. Next song");
            System.out.println("4. Display playlist");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            // check number not number input again
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scan.nextLine(); //skip the wrong line
                continue;
            }

            int choice = scan.nextInt();
            // skip the character after get newline
            scan.nextLine(); // bỏ ký tự xuống dòng sau số
            // avoid error 

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scan.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;

                case 2:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scan.nextLine();
                    playlist.removeSong(removeTitle);
                    break;

                case 3:
                    playlist.playNext();
                    break;

                case 4:
                    playlist.displayPlaylist();
                    break;

                case 0:
                    System.out.println("Exit Successfully!");
                    scan.close();
                    return; // exit

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
