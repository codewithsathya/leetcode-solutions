class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> hmap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < groupSizes.length; i++){
            if(!hmap.containsKey(groupSizes[i])){
                hmap.put(groupSizes[i], new ArrayList<>());
            }
            hmap.get(groupSizes[i]).add(i);
            if(hmap.get(groupSizes[i]).size() == groupSizes[i]){
                result.add(hmap.get(groupSizes[i]));
                hmap.remove(groupSizes[i]);
            }
        }
        return result;
    }
}