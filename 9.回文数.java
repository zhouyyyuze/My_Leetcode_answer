/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        int result = 0;
        int a = x;
        if(x<0){
            return false;
        }
        while(x != 0){
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10){
                return false; //因为x肯定符合大小，所以主要看输出的值是否在范围之内
            }
            int temp = x % 10;
            result = result*10 + temp;
            x/=10;
        }
        if(result == a){
            return true;
        }else{
            return false;
        }
    }
}
// @lc code=end

