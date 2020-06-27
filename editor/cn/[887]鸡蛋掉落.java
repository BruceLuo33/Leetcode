//你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。 
//
// 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。 
//
// 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。 
//
// 你的目标是确切地知道 F 的值是多少。 
//
// 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？ 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：K = 1, N = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
//否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
//如果它没碎，那么我们肯定知道 F = 2 。
//因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
// 
//
// 示例 2： 
//
// 输入：K = 2, N = 6
//输出：3
// 
//
// 示例 3： 
//
// 输入：K = 3, N = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= 100 
// 1 <= N <= 10000 
// 
// Related Topics 数学 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.27 第一遍
 - 思路：动态规划
 1. 确定状态与选择：状态为还剩下的鸡蛋数目与当前的层数；选择即为扔鸡蛋之后，碎还是没有碎；
 2. dp 数组的定义：因为状态有两个，所以 dp 数组应该是二维。dp[k][j] 表示有 k 个鸡蛋，处于 j 层时，需要测出 F 的最大次数。注意这里的 j 层并不代表现在就在 j 层，而是楼层数最大就是 j；
 3. base case：当楼层为 0 层的时候，不需要扔鸡蛋就知道 F = 0，因此 dp[k][0] = 0；当鸡蛋只有 k = 1 个了的时候，最坏情况是要从 0 层现行扫描到 N 层，dp[1][j] = j;
 4. 状态转移方程：状态的转移，来自于选择。如前所述，鸡蛋碎了或者没有，会造成不同的结果：
 - 假设在第 j 层往下扔鸡蛋，如果碎了，说明 F < j，所以 j 的取值要更新为 j - 1，即继续从 1... j-1 层往下扔鸡蛋；
 - 假设没有碎，说明 F > j，继续往 j + 1 ... N 层往下扔鸡蛋；
 - 将一栋楼分成了上下两个部分之后，分别将这两个部分视为新的楼，因此还需要对新的部分扫描。假设当前正处于 x 层，则有 transition 方程如下：
 - dp[k][j] = min(max(dp[k - 1][x - 1], dp[k][j - x]) + 1, localMin )
 5. 对于动态转移方程，如果第三个 x = 1 ... j 的循环用线性扫描，将会是O(K*N^2)的复杂度，超时。因此在这里需要用二分法来优化。
 - 复杂度分析：O(K*N^2) --> O(K*N*logN)
 */
class Solution {
    public int superEggDrop(int K, int N) {
        // if (K == 1) return N;
        int[][] dp = new int[N + 1][K + 1];
        // base case

        for (int i = 0; i <= K; i++) {
            dp[0][i] = 0; // zero floor
            dp[1][i] = 1;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        // transtion
        for (int n = 2; n <= N; n++) {
            for (int k = 2; k <= K; k++) {
                // int localMin = N + 1;
                // for (int x = 1; x <= j; x++) {
                //     localMin = Math.min(Math.max(dp[k - 1][x - 1], dp[k][j - x]) + 1, localMin);
                // }
                // dp[k][j] = localMin;
                int left = 1, right = n;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    int breakCount = dp[mid - 1][k - 1];
                    int notBreakCount = dp[n - mid][k];
                    if (breakCount > notBreakCount) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                dp[n][k] = Math.max(dp[left - 1][k - 1], dp[n - left][k]) + 1;
            }
        }

        return dp[N][K];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
