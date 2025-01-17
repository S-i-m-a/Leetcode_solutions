class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] distribution = new int[k];
        return backtrack(cookies, distribution, 0, k);
    }

    private int backtrack(int[] cookies, int[] distribution, int index, int k) {
       
        if (index == cookies.length) {
            int maxCookies = 0;
            for (int count : distribution) {
                maxCookies = Math.max(maxCookies, count);
            }
            return maxCookies;
        }

        int minUnfairness = Integer.MAX_VALUE;

       
        for (int i = 0; i < k; i++) {
            distribution[i] += cookies[index];

             
            minUnfairness = Math.min(minUnfairness, backtrack(cookies, distribution, index + 1, k));

             
            distribution[i] -= cookies[index];

          
            if (distribution[i] == 0) {
                break;
            }
        }

        return minUnfairness;
    }
}
