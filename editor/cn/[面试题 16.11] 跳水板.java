
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) {
            int[] ans = new int[1];
            ans[0] = shorter * k;
            return ans;    
        }
        int[] ans = new int[k + 1];
        int range = longer - shorter;
        int begin = shorter * k;
        for (int i = 0; i <= k; i++) {
            ans[i] = begin + range * i;
        }
        return ans;
    }
}
