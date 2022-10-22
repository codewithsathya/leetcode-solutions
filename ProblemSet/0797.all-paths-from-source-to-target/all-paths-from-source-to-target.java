class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, new HashMap<>());
        return result;
    }

    public void dfs(int[][] graph, int source, Map<Integer, Integer> prev){
        if(source == graph.length - 1){
            LinkedList<Integer> list = new LinkedList<>();
            int current = source;
            for(;current != 0; current = prev.get(current)){
                list.addFirst(current);
            }
            list.addFirst(0);
            result.add(list);
        }
        for(int neighbour: graph[source]){
            prev.put(neighbour, source);
            dfs(graph, neighbour, prev);
        }
    }
}