class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        int len = first.length();
        for(int i = len; i > 0; i--) {
            String pre;
            if(i == len) {
                pre = first;
            }else {
                pre = first.substring(0, i);
            }
            boolean swit = true;
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() < pre.length()){
                    swit = false;
                    break;
                }else if(strs[j].length() == pre.length()){
                    if(!strs[j].equals(pre)){
                        swit = false;
                        break;
                    }
                }else {
                    if(!strs[j].substring(0, i).equals(pre)){
                        swit = false;
                        break;
                    }
                }
            }
            if(swit){
                return pre;
            }
        }
        return "";
    }
}