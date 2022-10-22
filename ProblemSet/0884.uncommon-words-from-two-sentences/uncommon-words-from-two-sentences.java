class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] st1 = s1.split("[\s]");
        String[] st2 = s2.split("[\s]");

        Map<String, Integer> hmap = new HashMap<>();
        for(String str: st1){
            hmap.putIfAbsent(str, 0);
            hmap.put(str, hmap.get(str) + 1);
        }
        for(String str: st2){
            hmap.putIfAbsent(str, 0);
            hmap.put(str, hmap.get(str) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for(String key: hmap.keySet()){
            if(hmap.get(key) == 1){
                list.add(key);
            }
        }
        String[] result = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}