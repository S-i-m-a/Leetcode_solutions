import java.util.*;

public class Spreadsheet {
    private Map<String, Integer> cellValues;

    public Spreadsheet(int rows) {
        cellValues = new HashMap<>();
        // rows is given but not really needed, since unset cells default to 0
    }

    public void setCell(String cell, int value) {
        cellValues.put(cell, value);
    }

    public void resetCell(String cell) {
        cellValues.remove(cell);
    }

    public int getValue(String formula) {
        // formula always of the form "=X+Y"
        // where X and Y are either non-negative integers or cell references
        // cell references are like "A1", "B10", etc.
        // Leading "=" is present.

        // Skip the '='
        String expr = formula.substring(1);
        String[] parts = expr.split("\\+");
        int sum = 0;
        for (String part : parts) {
            sum += getOperandValue(part);
        }
        return sum;
    }

    private int getOperandValue(String operand) {
        if (operand.length() == 0) return 0;
        char first = operand.charAt(0);
        if (Character.isDigit(first)) {
            // it's a literal integer
            return Integer.parseInt(operand);
        } else {
            // it’s a cell reference
            return cellValues.getOrDefault(operand, 0);
        }
    }
}
