import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// --- Heap Implementation ---
class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    // Helper methods
    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }
    
    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Insert with upheap
    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1);
    }

    // Remove min (root) with downheap
    public K removeMin() {
        if (isEmpty()) return null;
        K answer = heap.get(0);
        K last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }
        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    // --- Upheap: restore heap-order after insert ---
    private void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (heap.get(j).compareTo(heap.get(p)) >= 0) break; // Heap-order ok
            swap(j, p);
            j = p;
        }
    }

    // --- Downheap: restore heap-order after removeMin ---
    private void downheap(int j) {
        while (left(j) < heap.size()) { // While j has left child
            int left = left(j);
            int right = right(j);
            int smallChild = left;
            if (right < heap.size() && heap.get(right).compareTo(heap.get(left)) < 0) {
                smallChild = right;
            }
            if (heap.get(smallChild).compareTo(heap.get(j)) >= 0) break;
            swap(j, smallChild);
            j = smallChild;
        }
    }
}

// --- HeapSort Driver ---
public class HeapSorter {
    public static void heapSort(Integer[] arr) {
        HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();
        
        // Phase 1: Insert (Construction)
        for (Integer x : arr) {
            pq.insert(x);
        }
        
        // Phase 2: Remove (Sorting)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.removeMin();
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[10];
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) data[i] = rand.nextInt(100);
        
        System.out.println("Before Sorting: " + Arrays.toString(data));
        heapSort(data);
        System.out.println("After Sorting:  " + Arrays.toString(data));
    }
}
