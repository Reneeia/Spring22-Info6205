package neu.jia.assignment01;

import java.util.*;

public class SortArrayByIncreasingFrequency {

    private static class CustomComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            if (o1.getValue() == o2.getValue()) {
                return o2.getKey() - o1.getKey();
            } else {
                return o1.getValue() - o2.getValue();
            }
        }
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new CustomComparator());

        int[] result = new int[nums.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            for (int j = 0; j < entry.getValue(); j++) {
                result[i] = entry.getKey();
                i++;
            }
        }
        return result;
    }
}
