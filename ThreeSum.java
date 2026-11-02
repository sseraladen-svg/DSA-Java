import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < sorted.length - 2; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = sorted.length - 1;
            while (left < right) {
                long sum = (long) sorted[i] + sorted[left] + sorted[right];
                if (sum == 0) {
                    result.add(Arrays.asList(sorted[i], sorted[left], sorted[right]));
                    int leftValue = sorted[left];
                    int rightValue = sorted[right];
                    while (left < right && sorted[left] == leftValue) {
                        left++;
                    }
                    while (left < right && sorted[right] == rightValue) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
