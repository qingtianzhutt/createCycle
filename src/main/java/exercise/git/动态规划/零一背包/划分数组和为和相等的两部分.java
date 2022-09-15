package exercise.git.动态规划.零一背包;

import java.util.Arrays;

public class 划分数组和为和相等的两部分 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        if (Arrays.stream(nums).sum()%2 != 0) {
            return false;
        }
        int m = nums.length;
        int n = Arrays.stream(nums).sum() / 2;
        int max = Arrays.stream(nums).max().getAsInt();
        if (max > n) {
            return false;
        }
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[m][n];
    }
}
