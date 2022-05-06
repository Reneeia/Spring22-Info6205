package neu.jia.info6205Final.question03;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        //edge case
        if (strs == null) {
            return result;
        }

        //hash map to store
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] current = strs[i].toCharArray();
            Arrays.sort(current);
            String key = String.valueOf(current);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        for (List<String> list : map.values()) {
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
