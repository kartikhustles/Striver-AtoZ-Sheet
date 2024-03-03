public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int fans = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                fans = Math.max(fans, ans);
                ans = 0;
            } else {
                ans++;
            }
        }

        return Math.max(fans, ans);
    }
}
