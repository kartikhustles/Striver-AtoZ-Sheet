public class MinSessions {
    public int minSessions(int[] tasks, int sessionTime) {
        int sum = 0;
        for (int i = 0; i < tasks.length; i++) {
            sum += tasks[i];
        }
        int ans = sum / sessionTime;
        if ((sum % sessionTime) == 0) {
            return ans;
        } else {
            return ans + 1;
        }
    }
}
