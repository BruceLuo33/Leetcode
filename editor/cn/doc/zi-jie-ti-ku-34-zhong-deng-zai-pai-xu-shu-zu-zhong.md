### 方法一：二分法。
1. 首先我们用 left 和 right 来找出 nums 中第一次出现 target 的索引位置。
2. 如果 nums 中存在 target，那么第一个 while 循环结束之后 left 就会指向 nums 中第一次出现 target 的索引位置。
3. 之后再从 left 处往后计算一共出现了多少次 target 即可。
#
### 先放C++代码，思路清晰明了。
```cpp
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.size() == 0) {
            return {-1, -1};
        }

        int left = 0, right = nums.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        if (nums[left] != target) {
            // 若 left 处的值不是 target，则 nums 中不存在 target
            return {-1, -1};
        }
        
        int count = left;

        for (int i = left + 1; i < nums.size(); ++i) {
            if (nums[i] == target) {
                ++ count;
            }
        }

        return {left, count};
    }
};
```
### 执行结果截图：
![image.png](https://pic.leetcode-cn.com/1606743289-vRJRwh-image.png)
#
### Tracker
1. 1刷：2020/11/30
