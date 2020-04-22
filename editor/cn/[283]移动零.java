//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {

        // 4.10 第一遍，4.22 第二遍
        // 思路：双指针。第一个指针指向第一个零数字，第二个指针移动。
        // 如果第二个指针指向零，则将其往后移动，直到遇到非零元素，
        // 然后将其与第一个指针所指向的零交换，交换之后两个指针都往后移动一次。
        // 如此遍历，直到终点
        // 有很多 if 的时候，要注意判断何时要加 else； 同时要注意两个指针都从0开始移动

        // 4.22 codes:
        if (nums.length == 1 || nums == null) return;
        int zeroLoc = 0, move = 0, len = nums.length;
        while (zeroLoc < len && move < len) {
            if (nums[zeroLoc] != 0) {
                zeroLoc += 1;
                move += 1;
            } else if (nums[move] == 0) {
                move += 1;
            } else if (nums[zeroLoc] == 0) {
                nums[zeroLoc] = nums[move];
                zeroLoc += 1;
                nums[move] = 0;
                move += 1;
            }
        }
        return;

        // 4.10 codes
        int zeroNums = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums  += 1;
            } else {
                nums[i - zeroNums] = nums[i];
            }
        }
        for (int i = nums.length - zeroNums; i < nums.length; i++) {
            nums [i] = 0;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
