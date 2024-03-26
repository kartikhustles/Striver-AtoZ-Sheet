class MinimumDeletionToMakeBeautifulArray {
    public static int minDeletion(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length - 1; i += 2) { // the second condition given
            if (nums[i] == nums[i + 1]) {
                counter++;
                i--;
            }
        }
        return (nums.length - counter) % 2 == 1 ? ++counter : counter; // checking if the array is even
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 2, 3, 3 };
        System.out.println(minDeletion(arr));
    }
}