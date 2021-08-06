/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length; // 数组长度
        Arrays.sort(nums);   // 将nums排序
        // 枚举 a
        int nearest = Math.abs(target)+Math.abs(nums[n-1])+Math.abs(nums[n-2])+Math.abs(nums[n-3]);
        int result = 0;
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int second = first + 1;
            int third = n - 1;
            while(second < third){
                
                int sum = nums[first] + nums[second] + nums[third];

                if (sum == target){
                    return target;
                }
                if (Math.abs(sum - target) <= nearest) {
                    nearest = Math.abs(sum - target);
                    result = sum;
                }

                if(sum > target){
                    third --;
                }else if(sum < target){
                    second ++;
                }
            }
        }
        return result;
    }
}

class test{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,2};
        int target = 0;
        int result = solution.threeSumClosest(nums, target);
        System.out.println(result);
    }
}

// @lc code=end

