import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public int firstUniqChar(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            frequencies.put(current, frequencies.getOrDefault(current, 0) + 1);
        }
        for (int i = 0; i < value.length(); i++) {
            if (frequencies.get(value.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
