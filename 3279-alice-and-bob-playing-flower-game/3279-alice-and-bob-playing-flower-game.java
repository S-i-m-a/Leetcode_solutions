class Solution {
    public long flowerGame(int n, int m) {
        long xEven = n / 2;
        long xOdd  = (n + 1) / 2;
        long yEven = m / 2;
        long yOdd  = (m + 1) / 2;
        return xOdd * yEven + xEven * yOdd;
    }
}
