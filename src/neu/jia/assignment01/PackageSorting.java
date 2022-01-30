package neu.jia.assignment01;

import java.util.*;

public class PackageSorting {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int i = arr.length - 1; i > 0; i--) {
            int idxOfMax = findBiggestIdx(arr, i);
            if(idxOfMax != i) {
                if(idxOfMax != 0) {
                    reverse(arr, idxOfMax); // move max to beginning
                    res.add(idxOfMax + 1); // record k: def of k is reverseEnd + 1;
                }
                reverse(arr, i); // move max to end
                res.add(i + 1); // record k: def of k is reverseEnd + 1;
            }
        }
        return res;
    }

    private void reverse (int[] arr, int k) {
        int start = 0;
        int end = k;
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap (int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private int findBiggestIdx(int[] arr, int end) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= end; i++) {
            if(arr[i] > max) {
                max = arr[i];
                res = i;
            }
        }
        return res;
    }
}
