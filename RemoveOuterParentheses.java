public class RemoveOuterParentheses {
    public String removeOuterParentheses(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        StringBuilder result = new StringBuilder(value.length());
        int depth = 0;
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            if (current == '(') {
                if (depth > 0) {
                    result.append(current);
                }
                depth++;
            } else if (current == ')') {
                if (depth == 0) {
                    throw new IllegalArgumentException("Parentheses must be balanced");
                }
                depth--;
                if (depth > 0) {
                    result.append(current);
                }
            } else {
                throw new IllegalArgumentException("Input must contain only parentheses");
            }
        }

        if (depth != 0) {
            throw new IllegalArgumentException("Parentheses must be balanced");
        }
        return result.toString();
    }
}
