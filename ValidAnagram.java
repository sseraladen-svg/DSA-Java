import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String first, String second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Input strings must not be null");
        }
        if (first.length() != second.length()) {
            return false;
        }

        char[] firstCharacters = first.toCharArray();
        char[] secondCharacters = second.toCharArray();
        Arrays.sort(firstCharacters);
        Arrays.sort(secondCharacters);
        return Arrays.equals(firstCharacters, secondCharacters);
    }
}
