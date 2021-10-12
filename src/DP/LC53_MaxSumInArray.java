package DP;

public class LC53_MaxSumInArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int[] dp = new int[len+1];
        int res = Integer.MIN_VALUE;

        for(int i = 1; i <= len; i++)
        {
            dp[i] = Math.max(array[i-1], array[i-1] + dp[i-1]);
            res = Math.max(res, dp[i]);

        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int totalMax = nums[0];
        int currMax = 0;

        for (int i  = 0; i < nums.length; i++)
        {
            if (currMax > 0)
            {
                currMax += nums[i];
            }
            else
            {
                currMax = nums[i];
            }
            totalMax = Math.max(currMax, totalMax);
        }

        return totalMax;

    }

}
