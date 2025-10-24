import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        // Các kích thước mảng cần kiểm tra
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("### The Sorting Race ###");

        // Lặp qua từng kích thước mảng
        for (int n : sizes) {
            System.out.println("\n### Testing for array size n = " + n + " ###");

            // Trường hợp trung bình: mảng ngẫu nhiên
            int[] average = generateRandomArray(n);
            runAndTimeAllSorts(average, "Average Case");

            // Trường hợp tốt nhất: mảng đã sắp xếp tăng dần
            int[] best = generateSortedArray(n);
            runAndTimeAllSorts(best, "Best Case");

            // Trường hợp tệ nhất: mảng sắp xếp giảm dần
            int[] worst = generateReverseSortedArray(n);
            runAndTimeAllSorts(worst, "Worst Case");
        }
    }

    /**
     * Chạy và đo thời gian 3 thuật toán sắp xếp cho từng trường hợp.
     */
    public static void runAndTimeAllSorts(int[] original, String caseType) {
        System.out.println("\n[" + caseType + "]");

        // Selection Sort
        int[] arr1 = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(arr1);
        long end = System.nanoTime();
        System.out.println("Selection Sort: " + (end - start) / 1_000_000.0 + " ms");

        // Insertion Sort
        int[] arr2 = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(arr2);
        end = System.nanoTime();
        System.out.println("Insertion Sort: " + (end - start) / 1_000_000.0 + " ms");

        // Merge Sort
        int[] arr3 = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(arr3);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) / 1_000_000.0 + " ms");
    }

    /**
     * Sinh mảng ngẫu nhiên (trường hợp trung bình)
     */
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    /**
     * Sinh mảng đã sắp xếp tăng dần (trường hợp tốt nhất)
     */
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * Sinh mảng sắp xếp giảm dần (trường hợp tệ nhất)
     */
    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}
