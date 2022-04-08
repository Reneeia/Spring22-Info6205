package neu.jia.assignment07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathVisitingAllNodes {

    public class Pair {
        int value;
        int status;

        public Pair(int value, int status) {
            this.value = value;
            this.status = status;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int FINAL_STATUS = (1 << n) - 1;

        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new Pair(i, (1 << i)));
        }
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair curPair = queue.poll();
                int curValue = curPair.value;
                int curStatus = curPair.status;
                String curStr = curValue + "#" + curStatus;
                visited.add(curStr);
                if (curStatus == FINAL_STATUS) {
                    return steps;
                }
                for (int nextValue : graph[curValue]) {
                    int nextStatus = curStatus | (1 << nextValue);
                    String nextStr = nextValue + "#" + nextStatus;
                    if (!visited.contains(nextStr)) {
                        visited.add(nextStr);
                        queue.offer(new Pair(nextValue, nextStatus));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
