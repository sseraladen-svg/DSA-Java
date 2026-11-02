import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        if (k < 0 || k > frequencies.size()) {
            throw new IllegalArgumentException("k must be between 0 and the number of unique values");
        }

        PriorityQueue<Integer> leastFrequentFirst = new PriorityQueue<>((a, b) -> {
            int byFrequency = Integer.compare(frequencies.get(a), frequencies.get(b));
            return byFrequency != 0 ? byFrequency : Integer.compare(b, a);
        });

        for (int num : frequencies.keySet()) {
            leastFrequentFirst.add(num);
            if (leastFrequentFirst.size() > k) {
                leastFrequentFirst.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = leastFrequentFirst.poll();
        }
        return result;
    }
}
