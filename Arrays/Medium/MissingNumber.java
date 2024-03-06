import java.util.*;

public class MissingNumber {

    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            if (nums[0] == 1) {
                return 0;
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1] + 1) {
                    return nums[i - 1] + 1;
                }
            }
            return nums.length;
        }
    }

    class Solution2 {
        public int missingNumber(int[] a) {
            int N = a.length;
            // Summation of first N numbers:
            int sum = (N * (N + 1)) / 2;

            // Summation of all array elements:
            int s2 = 0;
            for (int i = 0; i < N; i++) {
                s2 += a[i];
            }

            int missingNum = sum - s2;
            return missingNum;
        }
    }

    class Solution3 {
        public int missingNumber(int[] nums) {
            int allXOR = 0;
            int n = nums.length;
            for (int i = 1; i <= n; i++) {
                allXOR = allXOR ^ i;
            }

            for (int k : nums) {
                allXOR = allXOR ^ k;
            }
            return allXOR;
        }
    }

}