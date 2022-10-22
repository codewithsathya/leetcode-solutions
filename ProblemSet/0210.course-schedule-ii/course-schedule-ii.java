class Solution {
    boolean hasCycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] prerequisite: prerequisites){
            graph.putIfAbsent(prerequisite[0], new HashSet<>());
            graph.putIfAbsent(prerequisite[1], new HashSet<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[numCourses];
        int i = 0;

        for(int node = 0; node < numCourses; node++){
            if(!visited.contains(node)){
                dfs(node, graph, stack, visited, new HashSet<>());
                if(hasCycle) return new int[0];
                stack.push(node);
            }
        }
        while(!stack.isEmpty()){
            result[i++] = stack.pop();
        }
        return result;
    }



    public void dfs(int node, Map<Integer, Set<Integer>> graph, Stack<Integer> stack, Set<Integer> visited, Set<Integer> visiting){
        visiting.add(node);
        visited.add(node);
        if(!graph.containsKey(node)) return;
        Set<Integer> list = graph.get(node);
        for(int neighbour: list){
            if(visiting.contains(neighbour)){
                hasCycle = true;
            }
            if(!visited.contains(neighbour)){
                dfs(neighbour, graph, stack, visited, visiting);
                if(hasCycle) return;
                stack.push(neighbour);
            }
        }
        visiting.remove(node);
    }
}