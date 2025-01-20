import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        char startColumn = s.charAt(0);
        char endColumn = s.charAt(3);
        char startRow = s.charAt(1);
        char endRow = s.charAt(4);
        
        for (char col = startColumn; col <= endColumn; col++) {
            for (char row = startRow; row <= endRow; row++) {
                result.add("" + col + row);
            }
        }
        
        return result;
    }
}
