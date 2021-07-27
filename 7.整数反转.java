/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10){
                return 0; //因为x肯定符合大小，所以主要看输出的值是否在范围之内
            }
            int temp = x % 10;
            result = result*10 + temp;
            x/=10;
        }
        return result;
    }
}

// @lc code=end

