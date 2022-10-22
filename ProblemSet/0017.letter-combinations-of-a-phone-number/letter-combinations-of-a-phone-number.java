class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
        List<String> list = new ArrayList<>();
        helper(0, digits, map, "", list);
        return list;
    }

    public void helper(int index, String digits, Map<Character, Character[]> map, String str, List<String> result){
        if(digits.length() == 0) return;
        if(index >= digits.length()){
            result.add(str);
            return;
        }
        char ch = digits.charAt(index);
        for(char nextCh: map.get(ch)){
            helper(index + 1, digits, map, str + nextCh, result);
        }
    }
}