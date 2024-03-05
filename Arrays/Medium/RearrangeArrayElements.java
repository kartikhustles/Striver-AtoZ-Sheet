import java.util.*;

public class RearrangeArrayElements {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList();
        List<Integer> neg = new ArrayList();

        for (int x : nums) {
            if (x >= 0)
                pos.add(x);
            else
                neg.add(x);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = pos.get(i / 2);
            } else {
                nums[i] = neg.get(i / 2);
            }
        }

        return nums;
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0, neg = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 1;
        while (pos < n && neg < n) {
            if (nums[pos] >= 0)
                pos += 2;
            else if (nums[neg] < 0)
                neg += 2;
            else {
                int temp = nums[pos];
                nums[pos] = nums[neg];
                nums[neg] = temp;
            }
        }
        return nums;
    }
}