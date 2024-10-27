class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int counter = 0;
        if (numCourses <= 0) {
            return true;
        }

        // Initialize inDegree array and adjacency list
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and update inDegree for each node
        for (int[] edge : prerequisites) {
            int parent = edge[1];
            int child = edge[0];
            graph.get(parent).add(child);
            inDegree[child]++;
        }

        // Initialize the queue with courses having no prerequisites (inDegree = 0)
        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                sources.offer(i);
            }
        }

        // Process nodes with no prerequisites
        while (!sources.isEmpty()) {
            int course = sources.poll(); // dequeue
            counter++;

            // Process all the children of the current course
            for (int child : graph.get(course)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    sources.offer(child); // enqueue child if inDegree becomes 0
                }
            }
        }

        // If we processed all courses, return true
        return counter == numCourses;
    }
}