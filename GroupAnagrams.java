import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        Map<String, List<String>> groupsBySignature = new LinkedHashMap<>();
        for (String word : words) {
            if (word == null) {
                throw new IllegalArgumentException("Words must not contain null");
            }
            char[] signature = word.toCharArray();
            Arrays.sort(signature);
            groupsBySignature.computeIfAbsent(new String(signature), key -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groupsBySignature.values());
    }
}
