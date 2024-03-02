// 1st approach
// Space Complexity - O(k)

public class RotateArray {
    public static void rotate(int[] nums, int k) {// right
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[((i + k)) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate(arr, k);
    }

    // 2nd Approach
    // Space Complexity - O(1)
    public static void Reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to Rotate k elements to right
    public static void Rotateeletoright(int[] arr, int n, int k) {
        // Reverse first n-k elements
        Reverse(arr, 0, n - k - 1);
        // Reverse last k elements
        Reverse(arr, n - k, n - 1);
        // Reverse whole array
        Reverse(arr, 0, n - 1);
    }

    // public static void main(String args[]) {
    // int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
    // int n = 7;
    // int k = 2;
    // Rotateeletoright(arr, n, k);
    // System.out.print("After Rotating the k elements to right ");
    // for (int i = 0; i < n; i++)
    // System.out.print(arr[i] + " ");
    // System.out.println();
    // }
}
