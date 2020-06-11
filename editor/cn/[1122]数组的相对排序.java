//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.11 第一遍
 - 思路一：HashMap。
 1. 先用一个 map 来储存arr1中每个值即出现的次数，用 set 来储存 arr2 中出现过的值
 2. 遍历 arr2，将出现在 map 中的值加入到 ans 中，个数为 map 中 value 的数值
 3. 再新建一个 tmp 数组，遍历 arr1，将不在 set 中的元素加入到 tmp 数组中，sort 一下，再将 tmp 复制到ans后面
 4. 复制的时候要注意数组下标
 - 思路二：桶排序。其实思想和 map 还是比较类似，但是这里利用了 arr1 是一个整数数组这个特点，新建了一个 bucket 数组，它的下标代表的是 arr1 和 arr2 中元素的值，bucket 对应的值代表的是在 arr1 中出现的次数。
 1. 遍历 arr1，对于 arr1 中的每一个元素 num，令 bucket[num]++，这一步在于统计每个数字出现的频次；
 2. 遍历 arr2，对于 arr2 中的每一个元素 num2，令 bucket[num2]--，直到 bucket[num2] == 0，同时 ans[idx] = num2，这代表的是遇到了相同元素，那么将 arr1/bucket 中的所有元素全都取出来；
 3. 遍历 bucket，将值大于零的**下标**取出来，注意，不是取出 bucket[i] 而是 i，因为前者代表的是频次，并非数值，i 才是代表原来在 arr1，后面移动到了 bucket 中的数值
 - 复杂度分析：O(N)
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] ans = new int[arr1.length];
        for (int num : arr1) {
            bucket[num] += 1;
        }
        int idx = 0;
        for (int num : arr2) {
            while (bucket[num] > 0) {
                bucket[num]--;
                ans[idx++] = num;
            }
        }
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                ans[idx++] =i;
            }
        }
        return ans;

    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr2) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }
        for (int num : arr1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int num2 : arr2) {
            int n = map.get(num2);
            for (int i = 0; i < n; i++) {
                ans[index++] = num2;
            }
        }
        int[] tmp = new int[arr1.length - index];
        int index2 = 0;
        for (int num1 : arr1) {
            if (!set.contains(num1)) {
                tmp[index2++] = num1;
            }
        }
        Arrays.sort(tmp);
        for (int i = 0; i < tmp.length; i++) {
            ans[i + index] = tmp[i];
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
