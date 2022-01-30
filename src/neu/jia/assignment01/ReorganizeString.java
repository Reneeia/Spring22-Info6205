package neu.jia.assignment01;

import java.util.*;

public class ReorganizeString {

    private static class CustomComparator implements Comparator<Map.Entry<Character, Integer>> {
        @Override
        public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
            if (e1.getValue().equals(e2.getValue())) return 0;
            return e2.getValue() - e1.getValue();
        }
    }

    public String reorganizeString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;

        // key: char, value: freq
        Map<Character, Integer> map = getCharCountMap(s);

        // max heap order by char freq
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue(map.size(), new CustomComparator());

        // load entries to maxHeap
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        // if max char freq > s.length + 1 / 2 return ""
        if (!maxHeap.isEmpty() && maxHeap.peek().getValue() > (s.length() + 1) / 2) return "";

        StringBuilder sb = new StringBuilder();

        // load to result string builder
        while (!maxHeap.isEmpty()) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != maxHeap.peek().getKey()) {
                // if current entry not equal stringbuilder's last char, add it and decrease its freq
                Map.Entry<Character, Integer> maxEntry = maxHeap.poll();
                sb.append(maxEntry.getKey());
                maxEntry.setValue(maxEntry.getValue() - 1);
                if (maxEntry.getValue() > 0) {
                    maxHeap.offer(maxEntry);
                }
            } else {
                // if current entry equals stringbuilder's last char, poll the second largest item from maxHeap and add that
                Map.Entry<Character, Integer> maxEntry = maxHeap.poll();
                Map.Entry<Character, Integer> secondMaxEntry = maxHeap.poll();
                sb.append(secondMaxEntry.getKey());
                secondMaxEntry.setValue(secondMaxEntry.getValue() - 1);
                if (secondMaxEntry.getValue() > 0) {
                    maxHeap.offer(secondMaxEntry);
                }
                maxHeap.offer(maxEntry);
            }
        }
        return sb.toString();
    }

    private Map<Character, Integer> getCharCountMap(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (countMap.containsKey(currentChar)) {
                Integer currentFreq = countMap.get(currentChar);
                countMap.put(currentChar, currentFreq + 1);
            } else {
                countMap.put(currentChar, 1);
            }
        }
        return countMap;
    }
}
