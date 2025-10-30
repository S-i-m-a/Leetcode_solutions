class Solution {
    public int minNumberOperations(int[] target) {
        if (target == null || target.length == 0) return 0;
        int operations = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1];
            }
        }
        return operations;
    }
}
