class Solution {
    public int pivotInteger(int n) {
        int total = n * (n + 1) / 2;
        int x = (int)Math.sqrt(total);
        return x * x == total ? x : -1;
    }
}
