class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int attributeIndex = "type".equals(ruleKey) ? 0 : ("color".equals(ruleKey) ? 1 : 2);
    
        int matchCount = 0;
        for (List<String> item : items) {
            if (item.get(attributeIndex).equals(ruleValue)) {
                // If it matches, increment the count of matches.
                matchCount++;
            }
        }
      
        // Return the final count of matches.
        return matchCount;
    }
}