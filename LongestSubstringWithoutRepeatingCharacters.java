import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        Map<Character, Integer> lastSeenAt = new HashMap<>();
        int windowStart = 0;
        int maximumLength = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char current = s.charAt(windowEnd);
            Integer previousIndex = lastSeenAt.put(current, windowEnd);
            if (previousIndex != null) {
                windowStart = Math.max(windowStart, previousIndex + 1);
            }
            maximumLength = Math.max(maximumLength, windowEnd - windowStart + 1);
        }

        return maximumLength;
    }
}
