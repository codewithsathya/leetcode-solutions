class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(var list: paths){
            map.putIfAbsent(list.get(0), new ArrayList<>());
            map.putIfAbsent(list.get(1), new ArrayList<>());
            map.get(list.get(0)).add(list.get(1));
        }
        for(var key: map.keySet()){
            if(map.get(key).size() == 0){
                return key;
            }
        }
        return "";
    }
}