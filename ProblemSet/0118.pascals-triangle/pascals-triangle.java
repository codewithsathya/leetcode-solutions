class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            result.add(new ArrayList<>());
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    result.get(i).add(1);
                }else{
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    result.get(i).add(a + b);
                }
            }
        }
        return result;
    }
}