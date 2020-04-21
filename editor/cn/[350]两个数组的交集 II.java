//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 思路：判断 nums1 与 nums2 的长度，将较短的放入 hashMap 中，遇到相同的key则将value += 1
        // 在放入的过程中，更新value的方式就是重新put一次，在《算法4》234页有类似的操作
        // 然后循环 nums2，判断nums2 中的元素是否在 hashmap 中，若是，则将其放入 arraylist，然后vale -= 1
        // 采用 Arraylist 存放交集的原因，是数组长度固定，但是我们并不知道交集的大小，
        // 所以先存放到一个临时的容器里面，然后最后将其装入最终的数组
        // 复杂度：O（m+n），空间复杂度：O（n）
        if (nums2.length < nums1.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        ArrayList<Integer> tmpAns = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                tmpAns.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ans = new int[tmpAns.size()];
        int address = 0;
        for (int i : tmpAns) {
            ans[address] = i;
            address += 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
