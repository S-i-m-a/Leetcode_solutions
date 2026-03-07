class Solution {
    public int minFlips(String s) {
        int stringLength = s.length();
     
        String alternatingPattern = "01";
      
        int mismatchCount = 0;
        for (int i = 0; i < stringLength; ++i) {
           
            if (s.charAt(i) != alternatingPattern.charAt(i & 1)) {
                ++mismatchCount;
            }
        }

        int minFlipsNeeded = Math.min(mismatchCount, stringLength - mismatchCount);
      
        for (int i = 0; i < stringLength; ++i) {
           
            if (s.charAt(i) != alternatingPattern.charAt(i & 1)) {
                --mismatchCount;
            }
          
            if (s.charAt(i) != alternatingPattern.charAt((i + stringLength) & 1)) {
                ++mismatchCount;
            }
        
            minFlipsNeeded = Math.min(minFlipsNeeded, Math.min(mismatchCount, stringLength - mismatchCount));
        }
      
        return minFlipsNeeded;
    }
}