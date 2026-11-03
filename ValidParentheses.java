import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        Deque<Character> openings = new ArrayDeque<>();
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                openings.push(current);
                continue;
            }

            if (current != ')' && current != ']' && current != '}') {
                return false;
            }
            if (openings.isEmpty()) {
                return false;
            }

            char opening = openings.pop();
            if ((current == ')' && opening != '(')
                    || (current == ']' && opening != '[')
                    || (current == '}' && opening != '{')) {
                return false;
            }
        }
        return openings.isEmpty();
    }
}
