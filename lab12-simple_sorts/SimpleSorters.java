import java.util.Comparator;

public class SimpleSorters {

    /**
     * Sorts an array using the optimized Bubble Sort algorithm.
     * Bubble Sort hoạt động bằng cách duyệt qua mảng nhiều lần
     * và hoán đổi các phần tử kề nhau nếu chúng sai thứ tự.
     *
     * Bản "optimized" sử dụng biến `swapped` để phát hiện trường hợp
     * mảng đã được sắp xếp, từ đó dừng sớm → O(n) best case.
     */
  
    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;
// for loop outer
        // Vòng lặp ngoài: sau mỗi lần lặp, phần tử lớn nhất sẽ nổi lên cuối mảng.
        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;  // Đánh dấu xem có hoán đổi trong lượt này không

            // TODO: Implement the inner loop j
            // Vòng lặp trong so sánh từng cặp S[j] và S[j+1], dừng tại n-1-i
            // for output optimization
            // vì các phần tử cuối đã được sắp xếp.
            for (int j = 0; j < n - 1 - i; j++) {
// for loop inner 
                // So sánh 2 phần tử kề nhau.
                if (comp.compare(S[j], S[j + 1]) > 0) {

                    // TODO: Swap S[j] and S[j+1]
                    // Hoán đổi nếu sai thứ tự
                    
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;

                    swapped = true; // đánh dấu có hoán đổi
                }
            }
            // ... end inner loop ...

            // TODO: Add check for early termination
            // Nếu không có swap → mảng đã sorted → dừng sớm
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts an array using the Insertion Sort algorithm.
     *
     * Insertion Sort mô phỏng cách ta sắp xếp bài trên tay:
     * - Lấy S[i] làm "lá bài" cần chèn.
     * - Dời các phần tử lớn hơn nó sang phải.
     * - Chèn 'cur' vào đúng vị trí.
     *
     * Đây là thuật toán rất hiệu quả cho mảng gần như đã sắp xếp.
     */
    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;
// i run from 1 to n-1 because the first element is always considered "sorted"
        // i chạy từ 1 → n-1 vì phần tử đầu tiên luôn coi như "sorted"
        for (int i = 1; i < n; i++) {

            K cur = S[i];  // Lá bài cần chèn
            int j = i - 1;

            // TODO: Implement the while loop to shift elements
            // Dời các phần tử lớn hơn 'cur' sang phải.// shift elements to the right
            // So sánh S[j] > cur thì shift.// compare S[j] and cur
            // while loop, using comparator
            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            // TODO: Insert 'cur' into its correct position
            // j hiện tại đang ở vị trí nhỏ hơn cur, nên chèn vào j+1
            S[j + 1] = cur;
        }
    }
}
