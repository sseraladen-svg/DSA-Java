public class RemoveAdjacentDuplicatesInString {
    public String removeDuplicates(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        StringBuilder remaining = new StringBuilder(value.length());
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            int last = remaining.length() - 1;
            if (last >= 0 && remaining.charAt(last) == current) {
                remaining.deleteCharAt(last);
            } else {
                remaining.append(current);
            }
        }
        return remaining.toString();
    }
}
