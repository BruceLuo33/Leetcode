//你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对
//了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。 
//
// 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。 
//
// 请注意秘密数字和朋友的猜测数都可能含有重复数字。 
//
// 示例 1: 
//
// 输入: secret = "1807", guess = "7810"
//
//输出: "1A3B"
//
//解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。 
//
// 示例 2: 
//
// 输入: secret = "1123", guess = "0111"
//
//输出: "1A1B"
//
//解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。 
//
// 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。 
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        // 思路：for 循环，每次读取一个char，然后转换为 int
        // 判断两个数字是否相等，若是，则 bulls += 1；若不是，则需要判断cows
        // cows 的特征在于，数值相等，但位置不相等。因此可以这么判断：
        // 将numbers 数组想象为x轴，secret/guess 出现了某个数字，就分别将其 y 值 +1/-1
        // 判断 guess/secret 的值是否 >0/ <0，要注意这个顺序和上面的相反。
        // 如果是，说明之前出现过了，则将cows++。同时因为个数也要对应，所以需要将数字的 y值-1，拉回到x轴的水平线上面。
        // 各数对应是指： secret 中两个数字 1，即便 guess 有三个数字 1，也只能将 cows += 2
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < guess.length(); i++) {
            int charSecret = Character.getNumericValue(secret.charAt(i));
            int charGuess = Character.getNumericValue(guess.charAt(i));
            if (charGuess == charSecret) bulls += 1;
            else {
                if (numbers[charSecret] > 0) cows += 1;
                if (numbers[charGuess] < 0) cows += 1;
                numbers[charSecret] -= 1;
                numbers[charGuess] += 1;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
