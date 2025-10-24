public class SortingAlgorithms {

    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Thuật toán Selection Sort: 
        // Mỗi vòng lặp tìm phần tử nhỏ nhất trong phần còn lại của mảng
        // rồi hoán đổi nó với vị trí đầu tiên chưa được sắp xếp.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Tìm phần tử nhỏ nhất trong đoạn [i+1 .. n-1]
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Hoán đổi phần tử nhỏ nhất với phần tử ở vị trí i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Thuật toán Insertion Sort:
        // Chèn phần tử thứ i vào đúng vị trí trong dãy con [0..i-1] đã được sắp xếp.
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Dịch chuyển các phần tử lớn hơn key sang phải 1 vị trí
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Đặt key vào đúng vị trí
            arr[j + 1] = key;
        }
    }

    /**
     * Implements the Merge Sort algorithm. Public-facing method.
     * Theoretical Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Trường hợp mảng rỗng hoặc chỉ có 1 phần tử -> đã sắp xếp
        }

        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    // Hàm đệ quy chia mảng thành 2 nửa và sắp xếp từng nửa
    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return; // Điều kiện dừng: chỉ còn 1 phần tử

        int mid = left + (right - left) / 2;

        // Gọi đệ quy cho nửa trái và nửa phải
        mergeSortRecursive(arr, temp, left, mid);
        mergeSortRecursive(arr, temp, mid + 1, right);

        // Gộp hai nửa đã sắp xếp
        merge(arr, temp, left, mid, right);
    }

    // Hàm gộp hai mảng con đã sắp xếp
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // con trỏ cho mảng trái
        int j = mid + 1;  // con trỏ cho mảng phải
        int k = left;     // con trỏ cho mảng temp (tạm)

        // So sánh và chép phần tử nhỏ hơn vào mảng tạm
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Sao chép phần còn lại của mảng trái (nếu có)
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Sao chép phần còn lại của mảng phải (nếu có)
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Chép dữ liệu đã sắp xếp từ mảng tạm về mảng gốc
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
