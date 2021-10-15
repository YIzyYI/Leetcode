package EveryDay.Oct_2021;

public class Oct14_852 {
    public int peakIndexInMountainArray(int[] arr) {
        int res = 0, n = arr.length;
        for (int i = 1; i < n-1; i++)
        {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
                res = i;
        }

        return res;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        int n = arr.length;
        int left = 0, right = n-1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
            {
                return mid;
            }
            else if (arr[mid] > arr[mid-1])
            {
                left = mid + 1;
            }
            else if(arr[mid] > arr[mid+1])
            {
                right = mid - 1;
            }
        }
        return -1;
    }
}
