import java.util.*;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums)
    {
        int l  = 0;
        int r = nums.length - 1;

        while(l < r)
        {
            int mid = (l + (r - l) / 2);

            if(nums[mid] < nums[nums.length - 1])
            {
                r = mid;
            }
            else if(nums[mid] > nums[nums.length - 1])
            {
                l = mid + 1;
            }

            if(l == r)
            {
                return nums[l];
            }
        }
        return nums[l];
    }

    // 👉 MAIN METHOD FOR TESTING
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();

        // Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Min: " + sol.findMin(nums1)); // Expected: 1

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Min: " + sol.findMin(nums2)); // Expected: 0

        // Test Case 3
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Min: " + sol.findMin(nums3)); // Expected: 11

        // Edge Case
        int[] nums4 = {1};
        System.out.println("Min: " + sol.findMin(nums4)); // Expected: 1
    }
}