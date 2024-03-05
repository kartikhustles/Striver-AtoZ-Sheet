import java.util.ArrayList;
import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2 };

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1, number = nums[0];
        float n = nums.length;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                if (n / 3.00 < count) {
                    number = nums[i - 1];
                    list.add(number);
                }
                count = 1;
            }
        }
        if (n / 3.00 < count) {
            number = nums[nums.length - 1];
            list.add(number);
        }

        System.out.println(list);
    }
}
