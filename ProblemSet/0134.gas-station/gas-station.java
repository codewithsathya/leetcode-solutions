class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; ++i){
            if(canComplete(i, gas, cost, visited)){
                return i;
            }
        }
        return -1;
    }

    public boolean canComplete(int start, int[] gas, int[] cost, Set<Integer> visited){
        if(visited.contains(start)) return false;
        int remainingGas = 0;
        for(int curr = start; curr < gas.length; ++curr){
            remainingGas += gas[curr];
            remainingGas -= cost[curr];
            if(remainingGas < 0){
                return false;
            }else if(remainingGas == 0){
                visited.add(curr);
            }
        }
        for(int curr = 0; curr < start; ++curr){
            remainingGas += gas[curr];
            remainingGas -= cost[curr];
            if(remainingGas < 0){
                return false;
            }else if(remainingGas == 0){
                visited.add(curr);
            }
        }
        return true;
    }
}