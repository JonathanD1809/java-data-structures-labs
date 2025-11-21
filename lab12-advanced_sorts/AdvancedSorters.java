import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // --- MergeSort ---
    /**
     * Public wrapper cho Merge Sort.
     * MergeSort sử dụng kỹ thuật Divide–Conquer:
     * 1. Chia mảng thành hai nửa (Divide)
     * 2. Gọi đệ quy sắp xếp hai nửa (Conquer)
     * 3. Gộp hai nửa đã sorted vào lại mảng S (Combine)
     *
     * Tốn O(n) extra memory vì tạo S1, S2 mới.
     */
    /* using divide and conquer
    1. divide
    2. conquer 
    3. combine
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) return; // Base case: mảng size 0 hoặc 1 đã sorted

        // TODO: Divide
        // mid chia mảng thành S1 = [0..mid-1], S2 = [mid..n-1]
        // mid = n/2
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // TODO: Conquer (recursive calls)
        // Sắp xếp hai mảng con
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // TODO: Combine
        // Trộn hai mảng sorted S1 và S2 vào mảng S
        merge(S, S1, S2, comp);
    }

    /**
     * Hàm merge (kết hợp).
     * Mục tiêu: trộn hai mảng đã sorted (S1, S2) vào mảng S.
     * Đây là bước chạy O(n) vì mỗi phần tử được xử lý đúng 1 lần.
     */
    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<K> comp) {
        int i = 0; // index cho S1
        int j = 0; // index cho S2
        int k = 0; // index cho S

        // TODO: Implement the merge logic from the lecture
        // Lặp khi cả S1 và S2 đều còn phần tử
        while (i < S1.length && j < S2.length) {
            // Nếu S1[i] <= S2[j], đưa S1[i] vào S
            if (comp.compare(S1[i], S2[j]) <= 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }

        // TODO: Copy remaining elements of S1 or S2
        // Nếu S1 còn dư
        // if S1 still has elements
        while (i < S1.length) {
            S[k++] = S1[i++];
        }
        // Nếu S2 còn dư
        // if S2 still has elements
        while (j < S2.length) {
            S[k++] = S2[j++];
        }
    }

    // --- QuickSort ---
    /**
     * Public wrapper cho QuickSort.
     * Gọi recursive helper quickSort(S, 0, S.length-1).
     */
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    /**
     * Recursive helper cho QuickSort.
     * Base case: mảng có size 0 hoặc 1.
     * Partition chia mảng thành 2 phần quanh pivot.
     * Sau đó QuickSort từng phần.
     */
    private static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
        if (a >= b) return; // Base case

        // TODO: Divide
        // Partition trả về chỉ số pivot sau khi đặt pivot vào đúng vị trí
        //using partition method
        int pivotIndex = partition(S, comp, a, b);

        // TODO: Conquer (recursive calls)
        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    /**
     * Partition theo Hoare / Lomuto (tùy giảng viên dạy).
     * Ở đây chọn pivot = phần tử cuối (S[b]).
     * Mục tiêu: đưa pivot về đúng vị trí đã sorted.
     */
    private static <K> int partition(K[] S, Comparator<K> comp, int a, int b) {
        // TODO: Implement partition logic (e.g., Hoare's from lecture)

        // 1. Choose pivot
        K pivot = S[b]; // pivot = phần tử cuối

        // 2. left sẽ di chuyển tìm phần tử lớn hơn pivot
        // 2. left will find elements greater than pivot
        //    right sẽ tìm phần tử nhỏ hơn pivot
        //    right will find elements less than or equal to pivot
        int left = a - 1;

        // Di chuyển từ a tới b-1
        // Move from a to b-1
        for (int right = a; right < b; right++) {
            // Nếu S[right] <= pivot, đưa vào vùng bên trái
            // If S[right] <= pivot, move it to the left side
            if (comp.compare(S[right], pivot) <= 0) {
                left++;
                // Swap S[left] và S[right]
                K temp = S[left];
                S[left] = S[right];
                S[right] = temp;
            }
        }

        // 3. Đưa pivot vào vị trí đúng (left + 1)
        // 3. Place pivot in the correct position (left + 1)
        K temp = S[left + 1];
        S[left + 1] = S[b];
        S[b] = temp;

        // 4. Return final pivot index
        return left + 1;
    }
}
