class Solution {
    static class Pair{
        int num;
        int freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num: nums){
            if(hmap.containsKey(num)){
                hmap.put(num, hmap.get(num) + 1);
            }else{
                hmap.put(num, 1);
            }
        }
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int key: hmap.keySet()){
            pairs.add(new Pair(key, hmap.get(key)));
        }
        Collections.sort(pairs, (a, b) -> b.freq - a.freq);
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pairs.get(i).num;
        }
        return result;
    }
}