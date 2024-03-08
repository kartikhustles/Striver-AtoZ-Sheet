import java.util.Arrays;

public class MaxFrequencyElements {
    class Solution {
        public int maxFrequencyElements(int[] nums) {
            int n = nums.length, count = 1, maxFrequency = 1, initialFrequency = 1, i, ans;
            if (n == 0 || n == 1) {
                return n;
            }
            Arrays.sort(nums);

            for (i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    initialFrequency++;
                    if (initialFrequency == maxFrequency) {
                        count++;
                    } else if (initialFrequency > maxFrequency) {
                        maxFrequency = initialFrequency;
                        count = 1;
                    }
                } else {
                    initialFrequency = 1;
                }
            }
            ans = maxFrequency * count;
            if (ans == 1) {
                return n;
            }

            return ans;
        }
    }

    class Solution2 {
        public int maxFrequencyElements(int[] nums) {
            int maxNum = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num > maxNum)
                    maxNum = num;
            }

            int arr[] = new int[maxNum + 1];
            for (int num2 : nums) {
                arr[num2]++;
            }

            int maxFrequency = 0;
            for (int freq : arr) {
                if (freq > maxFrequency) {
                    maxFrequency = freq;
                }
            }

            int countMaxFrequency = 0;
            for (int freq : arr) {
                if (freq == maxFrequency) {
                    countMaxFrequency++;
                }
            }
            return maxFrequency * countMaxFrequency;
        }
    }
}
