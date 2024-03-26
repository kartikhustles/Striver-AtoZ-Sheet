import java.util.*;

public class MinimumDeletionToMakeArrayDivisible {
    public static int minOperations(int[] arr, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int i = 0; i < numsDivide.length; i++) {
            gcd = helper(numsDivide[i], gcd);
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (gcd % arr[i] == 0) {
                return count;
            } else {
                count += 1;
            }
        }
        return -1;
    }

    public static int helper(int a, int b) {
        if (b == 0)
            return a;
        return helper(b, a % b);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 2, 4, 3 };
        int[] numsDivide = { 9, 6, 9, 3, 15 };
        System.out.println(minOperations(nums, numsDivide));
    }
}