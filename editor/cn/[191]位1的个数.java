//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。 
//
// 
//
// 示例 1： 
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。 
// 
//
// 
//
// 进阶: 
//如果多次调用这个函数，你将如何优化你的算法？ 
// Related Topics 位运算


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.9 第一遍
 - 思路一：位运算。
 1. 方法一：不停的将 n 与 1 做 & 位运算，如果结果为 1，则代表最后一位的二进制数值为一，那么将 count += 1，同时进行无符号右移；
 2. 方法二：将 n 与 n - 1 做 & 运算，相当于每次都往前面借了一个“1”，例如原本是 001，n - 1之后就成了 000，因此就相当于数出来了一个 1，如此循环往复，直到 n == 0；
 - 思路二：将 int n 转换为二进制string，然后直接遍历
 */
public class Solution {
    // you need to treat n as an unsigned value

    // Solution Three：
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count += 1;
        }
        return count;
    }

    // Solution Two：
    // public int hammingWeight(int n) {
    //     int count = 0;
    //     while (n != 0) {
    //         n = n &(n-1);
    //         count += 1;
    //     }
    //     return count;
    // }

    // Solution one
    // public int hammingWeight(int n) {
    //     int count = 0;
    //     while (n != 0) {
    //         if ((n & 1) == 1) count += 1;
    //         n >>>= 1;
    //     }
    //     return count;
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
