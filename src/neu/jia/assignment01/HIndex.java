package neu.jia.assignment01;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int i = 1;
        for (; i <= n; i++) {
            if (citations[n - i] < i) {
                return i - 1;
            }
        }
        return i - 1;
    }
}
