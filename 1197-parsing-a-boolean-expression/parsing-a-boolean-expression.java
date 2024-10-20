public class Solution {
    
    // Main function to parse the boolean expression
    public boolean parseBoolExpr(String expression) {
        return evaluate(expression);
    }
    
    // Helper function to evaluate the expression recursively
    private boolean evaluate(String expression) {
        char firstChar = expression.charAt(0);
        
        if (firstChar == 't') return true;
        if (firstChar == 'f') return false;

        if (firstChar == '!') {
            // Negation, remove '!', parentheses and evaluate the inside
            return !evaluate(expression.substring(2, expression.length() - 1));
        }

        if (firstChar == '&') {
            // AND operation: all inner expressions must be true
            return processAndOr(expression, true);
        }

        if (firstChar == '|') {
            // OR operation: any inner expression can be true
            return processAndOr(expression, false);
        }

        return false;  // Should not reach here
    }

    // Helper function to handle AND ('&') and OR ('|') operations
    private boolean processAndOr(String expression, boolean isAnd) {
        int startIndex = 2;
        int openBrackets = 0;
        boolean result = isAnd;

        // Split the expressions by commas, respecting nested expressions
        for (int i = startIndex; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') openBrackets++;
            if (expression.charAt(i) == ')') openBrackets--;
            
            if ((expression.charAt(i) == ',' && openBrackets == 0) || i == expression.length() - 1) {
                String subExpr = expression.substring(startIndex, i + 1);
                if (isAnd) {
                    result &= evaluate(subExpr);
                    if (!result) return false;  // Short-circuiting for AND
                } else {
                    result |= evaluate(subExpr);
                    if (result) return true;  // Short-circuiting for OR
                }
                startIndex = i + 1;
            }
        }

        return result;
    }
}
