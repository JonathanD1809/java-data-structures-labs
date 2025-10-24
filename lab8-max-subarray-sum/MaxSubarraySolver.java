public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        // TODO: Implement the O(n^2) brute-force algorithm.

        int maxSum = Integer.MIN_VALUE; // Biến lưu tổng lớn nhất tìm được

        // Hai vòng lặp lồng nhau -> mỗi cặp (i, j) biểu diễn một mảng con
        // -> đây chính là lý do thuật toán có độ phức tạp O(n^2)
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0; // Tổng tạm thời của mảng con bắt đầu tại i

            for (int j = i; j < arr.length; j++) {
                // Mỗi lần lặp cộng thêm phần tử mới vào tổng
                currentSum += arr[j]; // Đây là thao tác cơ bản (primitive operation)

                // So sánh tổng hiện tại với tổng lớn nhất
                if (currentSum > maxSum) {
                    maxSum = currentSum; // Cập nhật nếu lớn hơn
                }
            }
        }

        // Trả về tổng lớn nhất sau khi duyệt hết các mảng con
        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        // TODO: Implement the O(n) Kadane's Algorithm.

        // Khởi tạo hai biến:
        // maxEndingHere: tổng lớn nhất kết thúc tại vị trí hiện tại
        // maxSoFar: tổng lớn nhất toàn cục đã tìm thấy
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        // Duyệt toàn bộ mảng đúng 1 lần (=> O(n))
        for (int i = 1; i < arr.length; i++) {

            // So sánh giữa việc bắt đầu lại mảng con mới hoặc cộng thêm phần tử hiện tại
            // Math.max giúp chọn phương án nào tốt hơn
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // Cập nhật tổng lớn nhất toàn cục
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        // Kết quả cuối cùng là tổng lớn nhất của mọi mảng con liên tiếp
        return maxSoFar;
    }
}
