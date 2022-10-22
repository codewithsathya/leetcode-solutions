class Solution {
    public boolean isSubsequence(String s, String t) {
        System.out.println(s + " " +  t);
        if(s.length() == 0){
            return true;
        }
        if(t.length() == 0){
            return false;
        }
        char ch = s.charAt(0);
        int pt = 0;
        while(t.charAt(pt) != ch){
            pt++;
            if(pt >= t.length()){
                return false;
            }
        }

        String subs = s.substring(1);
        String subt = t.substring(pt + 1);
        return isSubsequence(subs, subt);
    }
}