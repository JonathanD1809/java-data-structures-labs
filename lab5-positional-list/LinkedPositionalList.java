import java.util.Iterator;
import java.util.NoSuchElementException;

// Positional List set up Doubly Linked List
public class LinkedPositionalList<E> implements Iterable<E> {

    // --- Nested Node Class (implements Position) ---
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
        public void setElement(E e) { element = e; }
    }

    private Node<E> header;   // sentinel đầu
    private Node<E> trailer;  // sentinel cuối
    private int size = 0;

    // --- Constructor: tạo list rỗng với sentinel nodes ---
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    // --- Utility methods ---
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) return null;
        return node;
    }

    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid position");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null) throw new IllegalStateException("Position no longer in list");
        return node;
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    // --- Core Methods ---
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public Position<E> first() { return position(header.getNext()); }
    public Position<E> last() { return position(trailer.getPrev()); }

    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E old = node.getElement();
        node.setElement(e);
        return old;
    }

    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> pred = node.getPrev();
        Node<E> succ = node.getNext();
        pred.setNext(succ);
        succ.setPrev(pred);
        size--;

        E old = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return old;
    }

    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator<E> {
        Position<E> cursor = first(); // Start at first element

        public boolean hasNext() {
            return cursor != null;
        }

        public E next() {
            if (cursor == null) throw new NoSuchElementException();
            E element = cursor.getElement(); // store element
            cursor = after(cursor);          // advance
            return element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator(); // trả về iterator mới
    }
}
