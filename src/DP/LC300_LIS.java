package DP;

import java.util.Arrays;

public class LC300_LIS {

    public static void main(String[] args) {
        int[] nums = {1,4,3,4,2,3};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums)
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 0;

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if (dp[i] > res) res = dp[i];
                }
            }
        }




        return res;
    }
}
