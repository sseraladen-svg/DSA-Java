import java.util.LinkedHashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Input arrays must not be null");
        }

        Set<Integer> values = new LinkedHashSet<>();
        for (int value : nums1) {
            values.add(value);
        }

        Set<Integer> commonValues = new LinkedHashSet<>();
        for (int value : nums2) {
            if (values.contains(value)) {
                commonValues.add(value);
            }
        }

        int[] result = new int[commonValues.size()];
        int index = 0;
        for (int value : commonValues) {
            result[index++] = value;
        }
        return result;
    }
}
