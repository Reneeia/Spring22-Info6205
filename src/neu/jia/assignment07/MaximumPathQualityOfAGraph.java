package neu.jia.assignment07;

import java.util.ArrayList;
import java.util.List;

public class MaximumPathQualityOfAGraph {
    static class Edge {
        int nodeValue;
        int tCost;

        public Edge(int nodeValue, int tCost) {
            this.nodeValue = nodeValue;
            this.tCost = tCost;
        }
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int[] visited = new int[1000];
        List<Edge>[] edgeLists = new List[1000];
        int n = values.length;

        // transform edges to edgeLists
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            int tCost = edge[2];
            if (edgeLists[nodeA] == null) {
                edgeLists[nodeA] = new ArrayList<>();
            }
            if (edgeLists[nodeB] == null) {
                edgeLists[nodeB] = new ArrayList<>();
            }
            edgeLists[nodeA].add(new Edge(nodeB, tCost));
            edgeLists[nodeB].add(new Edge(nodeA, tCost));
        }

        visited[0] = 1;
        int[] result = new int[1];
        dfs(0, values[0], 0, result, maxTime, edgeLists, values, visited);
        return result[0];
    }

    private void dfs(int curNode, int totalValue, int totalTime, int[] result, int maxTime, List<Edge>[] edgeLists, int[] values, int[] visited) {

        if (totalTime > maxTime) {
            return;
        }

        if (curNode == 0) {
            result[0] = Math.max(result[0], totalValue);
        }
        if (edgeLists[curNode] != null) {
            for (Edge edge : edgeLists[curNode]) {
                int nextNode = edge.nodeValue;
                int tCost = edge.tCost;
                visited[nextNode]++;
                int nextTotalValue = totalValue + (visited[nextNode] == 1 ? values[nextNode] : 0);
                dfs(nextNode, nextTotalValue, totalTime + tCost, result, maxTime, edgeLists, values, visited);
                visited[nextNode]--;
            }
        }
    }
}
