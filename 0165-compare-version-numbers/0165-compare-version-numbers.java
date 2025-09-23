class Solution {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        
        int n1 = parts1.length;
        int n2 = parts2.length;
        int n = Math.max(n1, n2);
        
        for (int i = 0; i < n; i++) {
            // parse each segment; if one string is shorter, treat missing parts as 0
            int v1 = i < n1 ? Integer.parseInt(parts1[i]) : 0;
            int v2 = i < n2 ? Integer.parseInt(parts2[i]) : 0;
            
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
            // else, continue
        }
        
        return 0;
    }
}
