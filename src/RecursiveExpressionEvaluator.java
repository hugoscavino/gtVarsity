public class RecursiveExpressionEvaluator {
    public static int evaluateExpression(String expr) {
        // Base case: If the string contains only one digit, return its integer value
        if (expr.length() == 1) {
            return Character.getNumericValue(expr.charAt(0));
        }

        // Recursively find the last '+' or '-' operator
        int lastOperatorIndex = findLastOperator(expr);

        // If no operator is found (should not happen in valid input), return parsed number
        if (lastOperatorIndex == -1) {
            return Integer.parseInt(expr);
        }

        // Get left part and rightmost operand
        int leftValue = evaluateExpression(expr.substring(0, lastOperatorIndex));
        int rightValue = Character.getNumericValue(expr.charAt(lastOperatorIndex + 1));
        char operator = expr.charAt(lastOperatorIndex);

        // Apply the operator
        if (operator == '+') {
            return leftValue + rightValue;
        } else { // operator == '-'
            return leftValue - rightValue;
        }
    }

    // Helper function to find the last occurrence of '+' or '-'
    private static int findLastOperator(String expr) {
        for (int i = expr.length() - 1; i >= 0; i--) {
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                return i;
            }
        }
        return -1; // Should not happen for a valid expression
    }

    public static void main(String[] args) {
        System.out.println(evaluateExpression("3+2-1")); // 4
        System.out.println(evaluateExpression("9-5+2")); // 6
        System.out.println(evaluateExpression("7+8-3+2")); // 14
        System.out.println(evaluateExpression("5")); // 5
        System.out.println(evaluateExpression("1+2+3+4")); // 10
        System.out.println(evaluateExpression("9-8+4-2")); // 3
    }
}