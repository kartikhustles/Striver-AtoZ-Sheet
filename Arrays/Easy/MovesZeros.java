public class MovesZeros {
    public static void moveZeroes(int[] nums) {
        int pos = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 10, 0, 3, 12 };
        moveZeroes(arr);
    }
}
