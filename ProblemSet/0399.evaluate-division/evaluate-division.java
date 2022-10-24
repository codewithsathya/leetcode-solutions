class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int len = equations.size();
        for(int i = 0; i < len; i++){
            List<String> equation = equations.get(i);
            double value = values[i];
            String from = equation.get(0);
            String to = equation.get(1);
            map.putIfAbsent(from, new HashMap<>());
            map.get(from).put(to, value);
            map.putIfAbsent(to, new HashMap<>());
            map.get(to).put(from, 1 / value);
        }
        int qlen = queries.size();
        double[] result = new double[qlen];
        for(int i = 0; i < qlen; i++){
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            if(from.equals(to)){
                result[i] = map.containsKey(from) ? 1 : -1;
                continue;
            }
            if(!map.containsKey(from) || !map.containsKey(to)){
                result[i] = -1;
                continue;
            }
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new ArrayDeque<>();
            queue.add(from);
            visited.add(from);
            Map<String, String> parent = new HashMap<>();
            boolean done = false;
            while(!queue.isEmpty()){
                String current = queue.poll();
                for(String neighbour: map.get(current).keySet()){
                    if(!visited.contains(neighbour)){
                        queue.add(neighbour);
                        visited.add(neighbour);
                        parent.put(neighbour, current);
                    }
                    if(neighbour.equals(to)){
                        done = true;
                        break;
                    }
                }
                if(done){
                    break;
                }
            }
            if(!done){
                result[i] = -1;
                continue;
            }
            double product = 1;
            for(String current = to; !current.equals(from); current = parent.get(current)){
                product *= 1 / (map.get(current).get(parent.get(current)));
            }
            result[i] = product;
        }
        return result;
    }
}