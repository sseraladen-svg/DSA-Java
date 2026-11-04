import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long complement = (long) target - nums[i];
            if (complement >= Integer.MIN_VALUE && complement <= Integer.MAX_VALUE) {
                Integer previousIndex = indexByValue.get((int) complement);
                if (previousIndex != null) {
                    return new int[] {previousIndex, i};
                }
            }
            indexByValue.put(nums[i], i);
        }
        return new int[0];
    }
}
