package neu.jia.assignment01;

import java.util.*;

public class CustomSortString {

    private static class SortableChar {
        Map<Character, Integer> orderMap;
        Character value;

        public SortableChar(Map<Character, Integer> orderMap, Character value) {
            this.orderMap = orderMap;
            this.value = value;
        }
    }

    private static class CustomComparator implements Comparator<SortableChar> {
        @Override
        public int compare(SortableChar c1, SortableChar c2) {
            Map<Character, Integer> orderMap = c1.orderMap;
            if (orderMap.containsKey(c1.value) && orderMap.containsKey(c2.value)) {
                return orderMap.get(c1.value).compareTo(orderMap.get(c2.value));
            } else if (orderMap.containsKey(c1.value)) {
                return 1;
            } else if (orderMap.containsKey(c2.value)) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public String customSortString(String order, String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;

        Map<Character, Integer> orderMap = getOrderMap(order);

        List<SortableChar> charList = new ArrayList<>();
        // convert char to SortableChar and load to charList
        for (Character ch : s.toCharArray()) {
            charList.add(new SortableChar(orderMap, ch));
        }

        // do sort
        charList.sort(new CustomComparator());

        // use charList to construct string using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (SortableChar sChar : charList) {
            sb.append(sChar.value);
        }
        return sb.toString();
    }

    private Map<Character, Integer> getOrderMap(String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        return orderMap;
    }
}
