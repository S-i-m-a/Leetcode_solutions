import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length;
        
        int maxPoints = 1;
        
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0, vertical = 0, localMax = 0;
            
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }
                
                if (dx == 0) {
                    vertical++;
                    continue;
                }
                
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                
                String slope = dx + "/" + dy;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slope));
            }
            
            maxPoints = Math.max(maxPoints, Math.max(localMax, vertical) + duplicate + 1);
        }
        
        return maxPoints;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}