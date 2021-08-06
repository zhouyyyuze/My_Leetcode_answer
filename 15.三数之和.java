import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length; // 数组长度
        Arrays.sort(nums);   // 将nums排序
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;  //跳出并开始下一个循环
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;   //跳出循环
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}


class my_solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //创建arraylist ans用于存放结果
        int n = nums.length; //获取数组的长度
        Arrays.sort(nums); //给数组排序
        for(int first = 0; first < n ; ++first){
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            
            int third = n - 1;
            for(int second = first + 1; second < n; ++second){
                if(second > first+1 && nums[second] == nums[second-1]){
                    continue;
                }

                while (second < third && nums[first]+nums[second]+nums[third] > 0){
                    third--;
                }
                
                if (second == third){
                    break;
                }

                if (nums[first]+nums[second]+nums[third] == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }
        }
        return ans;
    }
}
// @lc code=end

