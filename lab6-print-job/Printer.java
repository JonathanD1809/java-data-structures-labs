// You will need a functioning Queue implementation (like LinkedQueue) for this to work.
// interface Queue { ... }
// class LinkedQueue implements Queue { ... }

import java.util.NoSuchElementException;

/**
 * Giao diện Queue đơn giản
 */
interface Queue<E> {
    int size(); // size

    boolean isEmpty(); // Kiểm tra hàng đợi có rỗng không

    void enqueue(E e); // adding

    E first(); // check without removing

    E dequeue(); // take and remove in front element .
}

/**
 * Cài đặt hàng đợi bằng danh sách liên kết
 */
class LinkedQueue<E> implements Queue<E> {

    // Node Link list Lớp Node dùng để tạo danh sách liên kết
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

    }

    private Node<E> head = null; // Đầu hàng đợi
    private Node<E> tail = null; // Cuối hàng đợi
    private int size = 0; // Số lượng phần tử

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        Node<E> newest = new Node<>(e, null); // Tạo node mới
        if (isEmpty()) {
            head = newest; // Nếu rỗng, head = newest
        } else {
            tail.next = newest; // Nối vào cuối hàng đợi

        }

        tail = newest; // Cập nhật tail

        size++;
    }

    public E first() {
        if (isEmpty())
            return null;
        return head.getElement(); // Trả về phần tử đầu tiên
    }

    public E dequeue() {
        if (isEmpty())
            return null;
        E answer = head.getElement(); // Lấy phần tử đầu tiên
        head = head.getNext(); // Di chuyển head
        size--;
        if (isEmpty())
            tail = null; // Nếu rỗng, tail = null
        return answer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk.getNext() != null)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }
}

/**
 * Represents a single document to be printed.
 */
class PrintJob {
    private String documentName;
    private int pageCount;

    // TODO: Implement the constructor
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // TODO: Implement the toString method to return a descriptive string
    // e.g., "PrintJob[Document: report.docx, Pages: 15]"
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}

/**
 * Simulates a printer that manages a queue of print jobs.
 */
public class Printer {
    private Queue<PrintJob> jobQueue;

    public Printer() {
        // TODO: Initialize the jobQueue with a LinkedQueue
        jobQueue = new LinkedQueue<>(); // Khởi tạo hàng đợi
    }

    /**
     * Adds a new print job to the rear of the queue.
     * 
     * @param job The print job to add.
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        // TODO: Enqueue the job
        jobQueue.enqueue(job); // Thêm vào hàng đợi
    }

    /**
     * Processes the job at the front of the queue.
     */
    public void processNextJob() {
        // TODO: Check if the queue is empty. If so, print a message.
        // If not empty, dequeue the job and print a "Processing..." message.
        if (jobQueue.isEmpty()) {
            System.out.println("The queue is empty!!!.");
        } else {
            PrintJob job = jobQueue.dequeue();
            System.out.println("Processing: " + job);
        }
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}
