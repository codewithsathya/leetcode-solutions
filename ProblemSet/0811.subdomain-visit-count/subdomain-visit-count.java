class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] strs = cpdomain.split(" ");
            int value = Integer.valueOf(strs[0]);
            String[] words = strs[1].split("[.]");
            String domain = "";
            for (int i = 0; i < words.length; i++) {
                if (domain.length() > 0) {
                    domain = "." + domain;
                }
                domain = words[words.length - 1 - i] + domain;
                map.put(domain, map.getOrDefault(domain, 0) + value);
            }
        }
        List<String> result = new ArrayList<>();
        for (String domain : map.keySet()) {
            String paired = map.get(domain) + " " + domain;
            result.add(paired);
        }
        return result;
    }
}