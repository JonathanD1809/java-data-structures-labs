import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSortDriver {
    public static void main(String[] args) {
        // Comparator chuẩn
        Comparator<Integer> comp = Comparator.naturalOrder();

        // Kích cỡ mảng test (đề bài yêu cầu 100+, nhưng dùng 20 để in kết quả)
        int N = 20;
        Random rand = new Random();

        // Tạo mảng ngẫu nhiên
        Integer[] arr1 = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = rand.nextInt(100); // số từ 0..99
        }

        // arr2 là bản copy để test QuickSort riêng
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test: Random Array (N=20) ---");
        System.out.println("Original: " + Arrays.toString(arr1));

        // Test MergeSort
        AdvancedSorters.mergeSort(arr1, comp);
        System.out.println("Merge Sort: " + Arrays.toString(arr1));

        // Test QuickSort
        System.out.println("Original: " + Arrays.toString(arr2));
        AdvancedSorters.quickSort(arr2, comp);
        System.out.println("Quick Sort: " + Arrays.toString(arr2));
    }
}
