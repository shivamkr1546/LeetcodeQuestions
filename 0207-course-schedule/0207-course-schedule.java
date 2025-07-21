class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create the adjacency list
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Step 2: Build the graph (prerequisite edges)
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj[prerequisite].add(course);  // directed edge: prerequisite → course
        }

        // Step 3: Compute in-degrees
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj[i]) {
                inDegree[neighbor]++;
            }
        }

        // Step 4: Initialize queue with nodes having in-degree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // Step 5: Perform topological sort
        int count = 0;  // tracks how many nodes we've processed
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int neighbor : adj[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // Step 6: Check for cycle
        return count == numCourses;  // if all nodes processed, no cycle
    }
}
