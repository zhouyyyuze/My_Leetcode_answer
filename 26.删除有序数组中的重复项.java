import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution2 {
    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i<nums.length-1){
            int j = i+1;

            if(j == nums.length){
                break;
            }

            while(nums[i]>=nums[j]){
                j++;
                if(j == nums.length){
                    break;
                }
            }

            if(j == nums.length){
                break;
            }
            nums[i+1] = nums[j];
            i++;
        }    
    
        for(int k = 0; k<nums.length;k++){
            System.out.println(nums[k]);
        }
        return i+1;  
    }   
}

class test2{
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1,2};
        int result = solution.removeDuplicates(nums);
        System.out.println(result);
    }
}

// @lc code=end

