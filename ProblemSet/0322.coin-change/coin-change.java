class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
  public int coinChange(int[] coins, int amount) {
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        int count = -1;
        for(int num: coins){
            int newTarget = amount - num;
            int countForNewTarget = coinChange(coins, newTarget);
            if(countForNewTarget < 0){
                continue;
            }else if(count < 0 || count > countForNewTarget + 1){
                count = countForNewTarget + 1;
            }
        }
        memo.put(amount, count);
        return count;
    }
}