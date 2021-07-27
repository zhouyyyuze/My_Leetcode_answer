/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m+n];
        int i = 0; // 用于在nums1中计数
        int j = 0; // 用于在nums2中计数
        int k = 0; // 用于在nums3中计数

        while(i < m || j < n){
            if(i < m && j < n){
                if(nums1[i] <= nums2[j]){
                    nums3[k] = nums1[i];
                    i++;
                    k++;
                }else{
                    nums3[k] = nums2[j];
                    j++;
                    k++;
                }
            }else if(i >= m && j < n){
                nums3[k] = nums2[j];
                j++;
                k++;
            }else if(i < m && j >= n){
                nums3[k] = nums1[i];
                i++;
                k++;
            }
        }

        if((m+n)%2 == 0){
            int mid1 = (m+n)/2;
            int mid2 = mid1+1;
            double result = (nums3[mid1-1]+nums3[mid2-1])/2.00;
            return result;
        }else{
            int mid = (m+n)/2;
            double result = nums3[mid];
            return result;
        }
    }
}

class test{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,4,10,20,44,111,2222,3333};
        int[] nums2 = {3,5,6,7,8,9,10,11,14};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
// @lc code=end

