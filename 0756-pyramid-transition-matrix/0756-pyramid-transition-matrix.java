class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Build map: key = 2-character string from bottom,
        // value = list of possible chars that can go on top
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s.charAt(2));
        }
        // Run DFS to try building the pyramid
        return dfs(bottom, "", 0, map);
    }

    private boolean dfs(String row, String nextRow, int index, 
                        Map<String, List<Character>> map) {
        // If row length is 1, we've built a complete pyramid
        if (row.length() == 1) {
            return true;
        }
        // If the current nextRow is complete for this level, build the next level
        if (nextRow.length() + 1 == row.length()) {
            return dfs(nextRow, "", 0, map);
        }
        // Get the pair at current index
        String pair = row.substring(index, index + 2);
        // If no allowed characters for this pair, this path fails
        if (!map.containsKey(pair)) {
            return false;
        }
        // Try all characters that can be placed above this pair
        for (char c : map.get(pair)) {
            if (dfs(row, nextRow + c, index + 1, map)) {
                return true;
            }
        }
        return false;
    }
}
