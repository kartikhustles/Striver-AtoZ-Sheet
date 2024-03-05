import java.util.*;

public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);

            int count = 1, maxCount = 1, number = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == nums[i]) {
                    count++;
                } else {
                    if (maxCount < count) {
                        number = nums[i - 1];
                        maxCount = count;
                    }
                    count = 1;
                }
            }
            if (maxCount < count) {
                number = nums[nums.length - 1];
            }

            return number;
        }
    }
}
