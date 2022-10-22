class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256];
        int[] ts = new int[256];
        Arrays.fill(st, -1);
        Arrays.fill(ts, -1);

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(st[ch1] == -1 && ts[ch2] == -1){
                st[ch1] = ch2;
                ts[ch2] = ch1;
            }else if(st[ch1] != ch2 || ts[ch2] != ch1){
                return false;
            }
        }
        return true;
    }
}