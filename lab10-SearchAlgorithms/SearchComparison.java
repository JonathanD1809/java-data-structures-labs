public class SearchComparison {

    /**
     * Lab 1a: Iterative Linear Search
     * Searches for 'key' in the array 'arr' one element at a time.
     * @param arr The array to search (can be unsorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int linearSearch(int[] arr, int key) {
        // TODO: Implement the iterative linear search algorithm.
        // Loop through the array from index 0 to the end.
        // If the element at the current index matches the key, return the index.

        for (int i = 0; i < arr.length; i++) {  // Duyệt toàn bộ mảng
            //traversing each element
            if (arr[i] == key) {                // So sánh từng phần tử// compare each element
                return i;                       // Trả về vị trí nếu tìm thấy// return index if found
            }
        }

        return -1; // Return -1 if the loop finishes without finding the key.


    }

    /**
     * Lab 1b: Iterative Binary Search
     * Searches for 'key' in a sorted array 'arr' using the divide-and-conquer method.
     * @param arr The array to search (MUST be sorted).
     * @param key The value to find.
     * @return The index of the key if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        // TODO: Implement the iterative binary search algorithm.
        // While low is less than or equal to high:
        // 1. Calculate the middle index: mid = (low + high) / 2
        // 2. If arr[mid] matches the key, return mid.
        // 3. If the key is less than arr[mid], update 'high'.
        // 4. If the key is greater than arr[mid], update 'low'.

        while (low <= high) {                    //
            // continue while there is a valid search range
            int mid = (low + high) / 2;        // find mid
            if (arr[mid] == key) {          // find key or target    
                return mid;                     
            } else if (arr[mid] < key) {         // key is in the right half   // Nếu key lớn hơn arr[mid]
                low = mid + 1;               // right half   
            } else {                           
                high = mid - 1;           // left half      
            }
        }

        return -1; // Return -1 if the loop finishes (low > high) without finding the key.
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData =   {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        // Test Linear Search
        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9));  // Expected: 4
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3));  // Expected: -1

        // Test Binary Search
        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9));    // Expected: 3
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3));    // Expected: -1
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30));  // Expected: 7
    }
}

















// this is a note for myself to compare the two search algorithms 
/*


 Linear Search
- Có thể áp dụng cho mảng chưa sắp xếp
- Duyệt tuần tự từng phần tử.
- Best-case: O(1)
- Worst-case: O(n)

 Binary Search
- Chỉ dùng khi **mảng đã sắp xếp tăng dần**.
- Mỗi lần loại bỏ một nửa không gian tìm kiếm.
- Best-case: O(1)
- Worst-case: O(log n)

 Nếu tìm số 30 trong mảng 8 phần tử:
   - Linear Search → 8 comparisons (duyệt hết)
   - Binary Search → ~3 comparisons (vì log₂8 ≈ 3)

 Nếu mảng tăng gấp đôi (N → 2N):
   - Linear Search → số phép so sánh **tăng gấp đôi**
   - Binary Search → số phép so sánh **tăng thêm 1** (vì log₂(2N) = log₂N + 1)

*/
