class Solution {
    public int findFinalValue(int[] nums, int original) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for (int x : nums) set.add(x);

        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }
}
