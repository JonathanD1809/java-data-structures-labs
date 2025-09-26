public class Playlist {
    
    // node inner class
    private static class Node {
        private Song song;    
        private Node next;    

        // Constructor full
        public Node(Song s, Node n) {
            this.song = s;
            this.next = n;
        }

        // Constructor tiện lợi (next = null)
        public Node(Song s) {
            this(s, null);
        }

        public Song getSong() { return song; }
        public Node getNext() { return next; }
        public void setNext(Node n) { next = n; }
    }

    //  attributes
    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    //add
    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) { 
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode); 
            tail = newNode;      
        }
        size++;
        System.out.println("Added: " + song);
    }

    // remove
    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (head.getSong().getTitle().equalsIgnoreCase(title)) {
            head = head.getNext(); 
            if (head == null) tail = null; 
            size--;
            System.out.println("Removed: " + title);
            return;
        }

        Node prev = head;
        Node curr = head.getNext();
        while (curr != null) {
            if (curr.getSong().getTitle().equalsIgnoreCase(title)) {
                prev.setNext(curr.getNext()); 
                if (curr == tail) tail = prev;
                size--;
                System.out.println("Removed: " + title);
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }

        System.out.println("Song not found: " + title);
    }

    // next song
    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        } else {
            currentNode = currentNode.getNext();
            if (currentNode == null) currentNode = head;
        }

        System.out.println("Now playing: " + currentNode.getSong());
    }

    // show playplist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty!!!!!!.");
            return;
        }

        Node temp = head;
        System.out.println("Playlist:");
        while (temp != null) {
            System.out.println(" => " + temp.getSong());
            temp = temp.getNext();
        }
    }
}
