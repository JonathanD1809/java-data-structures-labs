import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        
        System.out.println("### Maximum Subarray Sum Algorithm Comparison ###");

        for (int n : sizes) {
            System.out.println("\n### Testing for array size n = " + n + " ###");

            // Tạo mảng ngẫu nhiên gồm cả số âm và dương
            int[] arr = generateRandomArrayWithNegatives(n);

            // Đo thời gian chạy của thuật toán Brute-Force
            long start = System.nanoTime();
            MaxSubarraySolver.bruteForceMaxSum(arr);
            long end = System.nanoTime();
            double bruteTime = (end - start) / 1_000_000.0; // chuyển ns -> ms

            // Đo thời gian chạy của thuật toán Kadane
            start = System.nanoTime();
            MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            end = System.nanoTime();
            double kadaneTime = (end - start) / 1_000_000.0;

            // In kết quả thời gian ra màn hình
            System.out.printf("Brute Force: %.4f ms%n", bruteTime);
            System.out.printf("Kadane's Algorithm: %.4f ms%n", kadaneTime);

            // Giải thích:
            // Brute Force -> chậm dần theo n vì có hai vòng lặp (O(n^2))
            // Kadane -> rất nhanh vì chỉ một vòng lặp (O(n))
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Sinh mảng ngẫu nhiên có cả số âm và số dương
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(2001) - 1000; // tạo giá trị từ -1000 đến +1000
        }

        return arr;
    }
}
