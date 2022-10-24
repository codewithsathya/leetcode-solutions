class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<TreeSet<String>>> map = new HashMap<>();
        for(List<String> account: accounts){
            String name = account.get(0);
            int size = account.size();
            if(map.containsKey(name)){
                List<TreeSet<String>> list = map.get(name);
                TreeSet<String> common = null;
                for(TreeSet<String> mails: list){
                    for(int i = 1; i < size; i++){
                        if(mails.contains(account.get(i))){
                            common = mails;
                            break;
                        }
                    }
                    if(common != null){
                        break;
                    }
                }
                if(common != null){
                    for(int i = 1; i < size; i++){
                        common.add(account.get(i));
                    }
                }else{
                    TreeSet<String> newSet = new TreeSet<>();
                    for(int i = 1; i < size; i++){
                        newSet.add(account.get(i));
                    }
                    map.get(name).add(newSet);
                }
            }else{
                TreeSet<String> mails = new TreeSet<>();
                for(int i = 1; i < size; i++){
                    mails.add(account.get(i));
                }
                map.put(name, new ArrayList<>());
                map.get(name).add(mails);
            }

        }
        List<List<String>> result = new ArrayList<>();
        for(String key: map.keySet()){
            for(Set<String> set: map.get(key)){
                List<String> list = new ArrayList<>();
                list.add(key);
                for(String str: set){
                    list.add(str);
                }
                result.add(list);
            }
        }
        if(accounts.size() == result.size()){
            return result;
        }
        return accountsMerge(result);
    }
}