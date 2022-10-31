class Solution {
    static class Node{
        String creator;
        String id;
        int views;
        int totalViews;
        Node(String creator, String id, int views, int totalViews){
            this.creator = creator;
            this.id = id;
            this.views = views;
            this.totalViews = totalViews;
        }
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int len = creators.length;
        Map<String, Integer> totalViewsMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            totalViewsMap.put(creators[i], totalViewsMap.getOrDefault(creators[i], 0) + views[i]);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if(b.totalViews > a.totalViews){
                return 1;
            }else if(a.totalViews > b.totalViews){
                return -1;
            }else{
                if(b.views > a.views){
                    return 1;
                }else if(a.views > b.views){
                    return -1;
                }else{
                    return a.id.compareTo(b.id);
                }
            }
        });
        for(int i = 0; i < len; i++){
            pq.add(new Node(creators[i], ids[i], views[i], totalViewsMap.get(creators[i])));
        }
        List<List<String>> result = new ArrayList<>();
        Node node = pq.poll();
        List<String> list = new ArrayList<>();
        list.add(node.creator);
        list.add(node.id);
        result.add(list);
        Set<String> added = new HashSet<>();
        added.add(node.creator);
        while(!pq.isEmpty() && pq.peek().totalViews == node.totalViews){
            node = pq.poll();
            if(added.contains(node.creator)){
                continue;
            }
            added.add(node.creator);
            list = new ArrayList<>();
            list.add(node.creator);
            list.add(node.id);
            result.add(list);
        }
        return result;
    }
}