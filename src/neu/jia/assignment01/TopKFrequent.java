package neu.jia.assignment01;

import java.util.*;

public class TopKFrequent {

    private static class CustomComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {
            if (s1.getValue() == s2.getValue()) {
                return s1.getKey().compareTo(s2.getKey());
            } else {
                return s2.getValue() - s1.getValue();
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> freqMap = formMap(words);

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k, new CustomComparator());

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry);
        }

        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }

    private Map<String, Integer> formMap(String[] words) {
        Map<String, Integer> res = new HashMap<>();
        for (String word : words) {
            if (res.containsKey(word)) {
                res.put(word, res.get(word) + 1);
            } else {
                res.put(word, 1);
            }
        }
        return res;
    }
}
