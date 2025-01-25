class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int numFriends = hats.size();
        int maxHatNumber = 0;
      
        for (List<Integer> friendHats : hats) {
            for (int hat : friendHats) {
                maxHatNumber = Math.max(maxHatNumber, hat);
            }
        }

        List<Integer>[] hatToFriends = new List[maxHatNumber + 1];
        Arrays.setAll(hatToFriends, k -> new ArrayList<>());
      
        for (int i = 0; i < numFriends; ++i) {
            for (int hat : hats.get(i)) {
                hatToFriends[hat].add(i);
            }
        }

        final int MOD = (int) 1e9 + 7;
      
        int[][] dpTable = new int[maxHatNumber + 1][1 << numFriends];
      
        dpTable[0][0] = 1;
      
        for (int i = 1; i <= maxHatNumber; ++i) {
            for (int j = 0; j < 1 << numFriends; ++j) {
                dpTable[i][j] = dpTable[i - 1][j];
              
                for (int friendIndex : hatToFriends[i]) {
                    if ((j >> friendIndex & 1) == 1) {
                        dpTable[i][j] = (dpTable[i][j] + dpTable[i - 1][j ^ (1 << friendIndex)]) % MOD;
                    }
                }
            }
        }
      
        return dpTable[maxHatNumber][(1 << numFriends) - 1];
    }
}
