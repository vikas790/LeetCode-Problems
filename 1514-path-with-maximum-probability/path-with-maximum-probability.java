class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph.get(u).add(new int[]{v, i});
            graph.get(v).add(new int[]{u, i});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int node = (int) cur[0];
            double prob = cur[1];

            if (node == end) {
                return prob;
            }

            if (prob < maxProb[node]) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                double edgeProb = succProb[neighbor[1]];
                
                if (maxProb[nextNode] < prob * edgeProb) {
                    maxProb[nextNode] = prob * edgeProb;
                    pq.offer(new double[]{nextNode, maxProb[nextNode]});
                }
            }
        }

        return 0.0;
    }
}
