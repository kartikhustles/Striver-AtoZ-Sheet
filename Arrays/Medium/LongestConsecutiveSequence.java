import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1, current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else if (nums[i] != nums[i - 1]) {
                max = Math.max(current, max);
                current = 1;
            }
        }
        return Math.max(current, max);
    }
}