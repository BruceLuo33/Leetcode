//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] A) {
        /**
         * Solution 1:
         * Calculate the square of each elements
         * Using sort() function.
         * Time complexity: O(N) + O(NlogN)
         * */
//        for (int i = 0; i < A.length ; i++) {
//            A[i] = A[i] * A[i];
//        }
//        Arrays.sort(A);
//        return A;


        /**
         * Solution 2: two pointers
         * In the first solution, the info that the given array
         * is sorted are not utilized. To speed up our running time,
         * we could set the two pointers.*/
        int first = 0, last = A.length - 1, idx = last;
        int leftSquare, rightSquare;
        int[] nums = new int[A.length];
        while (idx >= 0) {
            leftSquare = A[first] * A[first];
            rightSquare = A[last] * A[last];
            if (leftSquare > rightSquare) {
                nums[idx] = leftSquare;
                first += 1;
            } else {
                nums[idx] = rightSquare;
                last -= 1;
            }
            idx -= 1;
        }
        return nums;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
