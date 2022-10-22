class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prerequisite: prerequisites){
            graph.putIfAbsent(prerequisite[0], new ArrayList<>());
            graph.putIfAbsent(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        Set<Integer> visiting = new HashSet<>();
        for(int node: graph.keySet()){
            if(!visiting.contains(node))
                if(hasCycle(graph, node, new HashSet<>(), visiting)){
                    return false;
                }
        }
        return true;
    }

    public boolean hasCycle(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited, Set<Integer> visiting){
        visited.add(start);
        visiting.add(start);
        for(int neighbour: graph.get(start)){
            if(visited.contains(neighbour)){
                return true;
            }else{
                if(visiting.contains(neighbour)){
                    continue;
                }
                boolean hasCycle = hasCycle(graph, neighbour, visited, visiting);
                if(hasCycle) return true;
            }
        }
        visited.remove(start);
        return false;
    }
}