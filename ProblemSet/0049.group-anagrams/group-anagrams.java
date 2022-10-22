class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] arr = new String[strs.length];
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            arr[i] = String.valueOf(charArr);
        }
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            if(hmap.containsKey(arr[i])){
                hmap.get(arr[i]).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hmap.put(arr[i], list);
            }
        }
        List<List<String>> result = new ArrayList<>(hmap.values());
        return result;
    }
}