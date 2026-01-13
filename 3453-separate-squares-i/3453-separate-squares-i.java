class Solution {
    public double separateSquares(int[][] squares) {
        // Compute total area of all squares
        long totalArea = 0;
        double maxY = 0;
        for (int[] sq : squares) {
            long l = sq[2];
            totalArea += l * l;
            // track maximum possible y where a square stops
            maxY = Math.max(maxY, sq[1] + sq[2]);
        }
        
        double target = totalArea / 2.0;
        double low = 0.0, high = maxY;
        
        // 60-100 iterations for precision up to 1e-5
        for (int i = 0; i < 80; i++) {
            double mid = (low + high) / 2.0;
            if (areaBelow(mid, squares) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return high;
    }
    
    private double areaBelow(double h, int[][] squares) {
        double area = 0.0;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            if (h <= y) {
                // line below square entirely => 0
                continue;
            } else if (h >= y + l) {
                // line above whole square
                area += l * l;
            } else {
                // line cuts through square
                area += l * (h - y);
            }
        }
        return area;
    }
}
